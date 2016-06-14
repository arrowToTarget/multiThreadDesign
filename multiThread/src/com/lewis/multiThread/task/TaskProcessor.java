package com.lewis.multiThread.task;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by zhangminghua on 2016/3/14.
 */
public class TaskProcessor {

    private ExecutorService executorService;

    private int coreSize;

    private int poolSize;

    TaskProcessor(int coreSize, int poolSize) {
        this.coreSize = coreSize;
        this.poolSize = poolSize;
        init();
    }

    private void init() {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "TaskProcessor-thread");
                t.setDaemon(true);
                return t;
            }
        };
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<Runnable>(coreSize);
        executorService = new ThreadPoolExecutor(coreSize, poolSize, 60, TimeUnit.SECONDS, queue, threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (executorService != null) {
                    try {
                        executorService.shutdown();
                        executorService.awaitTermination(5, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        //doLog
                    }
                }
            }
        });
    }

    /**
     * 执行TaskCallable任务,并等待返回结果
     * @param taskCallableList
     * @param <T> 返回结果的类型
     * @return 执行结果
     */
    public <T> List<T> executeTask(List<TaskCallable<T>> taskCallableList) {
        TaskCallable<T>[] taskCallableArray = new TaskCallable[taskCallableList.size()];
        taskCallableArray = taskCallableList.toArray(taskCallableArray);
        return executeTask(taskCallableArray);
    }

    /**
     * 执行TaskCallable任务,并等待返回结果
     * @param taskCallableArray
     * @param <T> 返回结果的类型
     * @return 执行结果
     */
    public <T> List<T> executeTask(TaskCallable<T>... taskCallableArray) {
        List<T> resultList = new LinkedList<T>();
        if (taskCallableArray != null && taskCallableArray.length > 0) {
            final CountDownLatch latch = new CountDownLatch(taskCallableArray.length);
            List<Future<T>> futureList = new LinkedList<Future<T>>();
            for (final TaskCallable<T> taskCallable : taskCallableArray) {
                Future<T> future = executorService.submit(new Callable<T>() {
                    @Override
                    public T call() throws Exception {
                        try {
                            return taskCallable.doCallable();
                        } finally {
                            latch.countDown();
                        }
                    }
                });
                futureList.add(future);
            }
            boolean isSuccess = false;
            try {
               isSuccess = latch.await(2,TimeUnit.SECONDS);
                if (!isSuccess) {
                    return resultList;
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException success :"+isSuccess);
            }

            try {
                for (Future<T> future : futureList) {
                    T t = future.get();
                    if (t != null) {
                        resultList.add(t);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<TaskCallable<Integer>> list = new LinkedList<TaskCallable<Integer>>();
        for (int i = 0; i < 10; i++) {
            list.add(new TaskCallable<Integer>() {
                @Override
                public Integer doCallable() throws Exception {
                    Thread.sleep(2000);
                    return 1+1;
                }
            });
        }
        TaskProcessor processor = new TaskProcessor(8,10);
        long beginTime = System.currentTimeMillis();
        List<Integer> integers = processor.executeTask(list);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        System.out.println("endTime is ="+(System.currentTimeMillis()-beginTime));
    }

    /**
     * 异步执行任务TaskCallable,不用等待执行结果
     * @param taskCallableList
     */
    public void executeTaskAsyn(List<TaskCallable<?>> taskCallableList){
        if (taskCallableList != null && taskCallableList.size() > 0) {
            TaskCallable<?>[] taskCallables = new TaskCallable[taskCallableList.size()];
            taskCallables = taskCallableList.toArray(taskCallables);
            executeTaskAsyn(taskCallables);
        }
    }
    /**
     * 异步执行任务TaskCallable,不用等待执行结果
     * @param taskCallables
     */
    public void executeTaskAsyn(TaskCallable<?> ... taskCallables){
        if (taskCallables != null && taskCallables.length > 0) {
            for (final TaskCallable<?> taskCallable : taskCallables ){
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            taskCallable.doCallable();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        }
    }

    public <T> List<T> executeTaskByConcurrentControl(final int concurrentCount, List<TaskCallable<T>> tasks) {
        TaskCallable<T>[] actions = new TaskCallable[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            actions[i] = tasks.get(i);
        }
        return executeTaskByConcurrentControl(concurrentCount, actions);
    }


    /**
     * 并发控制任务执行
     * @param concurrentCount 并行任务数
     * @param tasks
     * @return
     */
    public <T> List<T> executeTaskByConcurrentControl(int concurrentCount, TaskCallable<T>... tasks) {
        int modTaskCount = tasks.length;
        if (concurrentCount > coreSize) {
            concurrentCount = coreSize;
        }
        int remainTaskCount = tasks.length % concurrentCount;
        List<T> resultList = new ArrayList<T>(modTaskCount);
        List<Future<T>> futures = new ArrayList<Future<T>>(tasks.length);

        Map<Integer, TaskCallable<T>[]> currentTaskMap = new HashMap<Integer, TaskCallable<T>[]>(2);
        currentTaskMap.put(concurrentCount, Arrays.copyOf(tasks, modTaskCount));

        if (remainTaskCount != 0 && remainTaskCount != modTaskCount) {
            modTaskCount = tasks.length - remainTaskCount;
            currentTaskMap.put(concurrentCount, Arrays.copyOf(tasks, modTaskCount));
            currentTaskMap.put(remainTaskCount, Arrays.copyOfRange(tasks, modTaskCount, tasks.length));
        }
        for (Map.Entry<Integer, TaskCallable<T>[]> entry : currentTaskMap.entrySet()) {
            futures.addAll(barrier(entry.getKey(), entry.getValue()));
        }

        for (Future<T> future : futures) {
            try {
                T result = future.get();
                if (result != null) {
                    resultList.add(result);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return resultList;
    }

    private <T> List<Future<T>> barrier(final int concurrentCount, TaskCallable<T>... tasks) {
        List<Future<T>> futures = new ArrayList<Future<T>>(tasks.length);
        int latchNumber = tasks.length < concurrentCount ? tasks.length : concurrentCount;
        int devide = tasks.length / concurrentCount == 0 ? 1 : tasks.length / concurrentCount;
        for (int i = 0; i < devide; i++) {
            TaskCallable<T>[] newTaskActionAry = Arrays
                    .copyOfRange(tasks, i * concurrentCount, (i + 1) * concurrentCount);
            final CountDownLatch latch = new CountDownLatch(latchNumber);
            for (final TaskCallable<T> action : newTaskActionAry) {
                if (action == null) {
                    continue;
                }
                Future<T> future = executorService.submit(new Callable<T>() {
                    @Override
                    public T call() throws Exception {
                        try {
                            return action.doCallable();
                        } finally {
                            latch.countDown();
                        }
                    }
                });
                futures.add(future);
            }
            try {
                latch.await();
            } catch (InterruptedException e) {
                //doLog
            }
        }
        return futures;
    }


    public <T> Map<String,T> executeNamedTask(List<NamedTaskCallable<T>> taskCallableList){
        if (taskCallableList != null && taskCallableList.size() > 0) {
            NamedTaskCallable<T>[] taskCallableArray = new NamedTaskCallable[taskCallableList.size()];
            taskCallableArray = taskCallableList.toArray(taskCallableArray);
            return executeNamedTask(taskCallableArray);
        }
        return new HashMap<String, T>(0);
    }

    public <T> Map<String,T> executeNamedTask(NamedTaskCallable<T> ... namedTaskCallables){
        Map<String,T> retMap = new HashMap<String, T>(namedTaskCallables.length);
        if (namedTaskCallables != null && namedTaskCallables.length > 0) {
            final CountDownLatch latch = new CountDownLatch(namedTaskCallables.length);
            Map<String,Future<T>> futureMap = new HashMap<String, Future<T>>(namedTaskCallables.length);
            for (final NamedTaskCallable<T> namedTaskCallable : namedTaskCallables){
                Future<T> future = executorService.submit(new Callable<T>() {
                    @Override
                    public T call() throws Exception {
                        try {
                            return namedTaskCallable.doCallable();
                        } finally {
                            latch.countDown();
                        }
                    }
                });
                futureMap.put(namedTaskCallable.name(),future);
            }

            try {
                latch.await();
            } catch (InterruptedException e) {
                //dolog
            }
            Iterator<Map.Entry<String, Future<T>>> iterator = futureMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Future<T>> futureEntry = iterator.next();
                try {
                    T result = futureEntry.getValue().get();
                    if (result != null) {
                        retMap.put(futureEntry.getKey(), result);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return retMap;
    }

    public <T> List<T> executeTaskConcurrent(List<TaskCallable<T>> taskCallableList,int concurrentSize){
        if (taskCallableList != null && taskCallableList.size() > 0) {
            TaskCallable<T>[] taskCallables = new TaskCallable[taskCallableList.size()];
            taskCallables = taskCallableList.toArray(taskCallables);
            executeTaskConcurrent(concurrentSize,taskCallables);
        }
        return new ArrayList<T>(0);
    }


    public <T> List<T> executeTaskConcurrent(int concurrentSize,TaskCallable<T> ... taskCallables){
        List<T> resultList = new ArrayList<T>(taskCallables.length);
        final Semaphore semaphore = new Semaphore(concurrentSize,true);
        for (final TaskCallable<T> taskCallable : taskCallables){
            executorService.submit(new Callable<T>() {
                @Override
                public T call() throws Exception {
                    try {
                        System.out.println(Thread.currentThread().getName()+" semaphore acquire  before: "+semaphore.availablePermits());
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+" semaphore acquire  after: "+semaphore.availablePermits());
                        return taskCallable.doCallable();
                    } finally {
                        System.out.println(Thread.currentThread().getName()+ " semaphore release  before: "+semaphore.availablePermits());
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName()+" semaphore release  after: "+semaphore.availablePermits());
                    }
                }
            });
        }
        return resultList;
    }


}
