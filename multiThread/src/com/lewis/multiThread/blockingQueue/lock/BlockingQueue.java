package com.lewis.multiThread.blockingQueue.lock;

import com.lewis.multiThread.blockingQueue.Request;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangminghua on 2016/3/21.
 */
public class BlockingQueue {

    private final Request[] table;

    private int header ;
    private int tail ;
    private int count;
    private Lock lock = new ReentrantLock();
    //condition for take
    private Condition notEmpty = lock.newCondition();
    //condition for put
    private Condition notFull = lock.newCondition();
    public BlockingQueue(int count) {
        this.count = 0;
        this.header = 0;
        this.tail = 0;
        this.table = new Request[count];
    }

    public Request take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count <= 0) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    //do interruptedException process
                    notEmpty.signal();
                    throw e;
                }
            }
            Request request = table[header];
            table[header] = null;
            header = (++header)%table.length;
            count--;
            notFull.signalAll();
            return request;
        } finally {
            lock.unlock();
        }
    }

    public void put(Request request) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count >= table.length){
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    notFull.signal();
                    throw e;
                }
            }
            table[tail] = request;
            tail = (++tail)%table.length;
            count++;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }



    public int size(){
        return count;
    }

    //取走所有的请求
    public void clear(){
        if (lock.tryLock()){
            try {
                count = 0;
                header = 0;
                tail = 0;
                notFull.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
