package com.lewis.multiThread.task;

/**
 * Created by zhangminghua on 2016/3/14.
 * 执行器工厂
 */
public class TaskProcessorFactory {
    private static final int DEFAULT_CORE_SIZE = Runtime.getRuntime().availableProcessors();

    private static final int DEFAULT_POOL_SIZE = DEFAULT_CORE_SIZE * 2;
    private int coreSize = DEFAULT_CORE_SIZE;

    private int poolSize = DEFAULT_POOL_SIZE;

    public TaskProcessor createTaskProcessor(int coreSize,int poolSize){
        return new TaskProcessor(coreSize,poolSize);
    }

    public TaskProcessor createTaskProcessor(){
        return createTaskProcessor(DEFAULT_CORE_SIZE,DEFAULT_POOL_SIZE);
    }
    public void setCoreSize(int coreSize) {
        this.coreSize = coreSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }
}
