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
    public synchronized Request take() {
        //警戒条件count == 0表示容器中没有请求的数据，要获取数据，当前线程必须等待
        while (count <= 0) {
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
        //将header++，并将header对queue.length求模，防止header超过数组的大小
        header = (header+1) % queue.length;
        //将数量减一
        count--;
        //通知其他线程，队列里的数据量减少了一个(如果之前有线程要进行put操作，但是因为数组满了，没有空间可以存储数据了，就必须等待wait)，
        // 此时等待的线程收到了通知 就可以从waiting pool从出来，继续进行put操作了
        notifyAll();
        return request;
    }

    //向队列中插入数据
    public synchronized void put(Request request) {
        //count >= queue.length 是插入数据的警戒条件，表示数组里面没有可用的空间了，不能再插入数据了，此时必须等待
        while (count >= queue.length) {
            try {
                //wait()方法会抛出InterruptedException，可捕获该异常后进行中断异常的处理，
                // 注意：wait方法必须在线程持有对象的监视器monitor后才能调用，否则java.lang.IllegalMonitorStateException
                wait();
            } catch (InterruptedException e) {
                //process interrupted case
            }
        }
        //程序走到这，说明数组里有可用的空间，则直接在tail位置进行数据的插入
        queue[tail] = request;
        //将tail++，并将tail对queue.length求模,防止tail超过数组的大小
        tail = (tail+1) % queue.length;
        //将count++
        count++;
        //通知其他线程，队列里的数据量多了一个(如果之前有线程要进行take操作，但是因为数组是空的，没有可用的数据，就必须等待wait)，
        // 此时等待的线程收到了通知 就可以从waiting pool从出来，继续进行take操作了
        notifyAll();
    }

    public int size() {
        return count;
    }

}
