package com.lewis.multiThread.blockingQueue.syn;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangminghua on 2016/3/18.
 * 模拟一个请求
 */
public class Request {
    //请求ID
    private int id;
    //请求内存
    private String content;

    private String contextThread;

    public Request(int id, String content,String contentThread) {
        this.id = id;
        this.content = content;
        this.contextThread = contentThread;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", contextThread='" + contextThread + '\'' +
                '}';
    }

    private Lock  lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void doSom(){
        lock.lock();
        try {
            System.out.println("before await..");
            condition.await();
            System.out.println("after await..");
        } catch (InterruptedException e) {

        }finally {
            lock.unlock();
        }
    }
    
    public void dundo(){
        lock.lock();
        try {
            System.out.println("before signal..");

            condition.signal();
            System.out.println("after signal..");

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        System.out.println("haha");
        final Request request = new Request(100, "haha", Thread.currentThread().getName());
        new Thread(){
            @Override
            public void run() {
                request.doSom();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                request.dundo();
            }
        }.start();

    }
}
