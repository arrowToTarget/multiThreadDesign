package com.lewis.multiThread.blockingQueue.syn;


/**
 * Created by zhangminghua on 2016/3/18.
 * 自己实现的阻塞队列
 */
public class MyBlockingQueue {
    //用来存储请求数据的容器，设置为final表示该容器在构造器中只会被初始化一次
    private final Request[] queue;
    //下一次放置（put）请求数据的位置
    private int tail;
    //下一次获取(take) 请求数据的位置
    private int header;
    //记录容器中现在有多少个请求数据
    private int count;

    public MyBlockingQueue(int count) {
        this.tail = 0;
        this.header = 0;
        this.count = 0;
        queue = new Request[count];
    }

    //从队列中取值
    public Request take(){
        synchronized (this){
            //警戒条件count == 0表示容器中没有请求的数据，要获取数据，必须等待
            while (count == 0) {
                try {
                    //wait()方法会抛出InterruptedException，可捕获该异常后进行中断异常的处理，
                    // 注意：wait方法必须在线程持有对象的监视器monitor后才能调用，否则java.lang.IllegalMonitorStateException
                    wait();
                } catch (InterruptedException e) {
                    //process interrupted case
                }
            }
            //程序执行到这里，说明容器中存在请求数据，则直接从header位置获取请求数据
            Request request = queue[header];
            //
            header = (header++)%queue.length;
            count--;
            notifyAll();
            return request;
        }
    }

    public void put(Request request){
        synchronized (this){
            while (count >= queue.length) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    //process interrupted case
                }
                queue[tail] = request;
                tail = (tail++)%queue.length;
                count++;
                notifyAll();
            }
        }
    }


}
