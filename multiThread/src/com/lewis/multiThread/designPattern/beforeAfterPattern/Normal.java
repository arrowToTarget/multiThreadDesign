package com.lewis.multiThread.designPattern.beforeAfterPattern;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangminghua on 2016/3/23.
 * 下面演示的是 before after pattern
 * Lock lock = new ReentrantLock();
 *  一般情况下，我们使用Lock是这样写：当执行lock.lockInterruptibly()方法时，
 *  如果该锁已被其他的线程锁占用，那当前线程会处于等待状态，若其他线程对当前线程执行了interrupt方法，中断了当前线程的等待，
 *  则lock.lockInterruptibly()会抛出InterruptedException异常，那lock.unlock()方法便不会执行，
 *  这是合理的，因为当前线程之前一直处于waiting状态没有获得锁，当然不用解锁
 *   lock.lockInterruptibly();
 *   try{
 *      executeMethod();
 *   }finally{
 *       lock.unlock();
 *   }
 *
 *   上面应用的就是before after pattern
 *   但如果我们将 lock.lock()写在try语句块内部，会发生什么情况呢？
 *  当执行lock.lockInterruptibly()方法时，
 *  如果该锁已被其他的线程锁占用，那当前线程会处于等待状态，若其他线程对当前线程执行了interrupt方法，中断了当前线程的等待，
 *  则lock.lockInterruptibly()会抛出InterruptedException异常，又因为lock.lockInterruptibly()方法再try语句块内，那lock.unlock()方法也会执行，
 *  这就是不合理的，因为当前线程之前一直处于waiting状态没有获得锁，但是你却要解锁，这就不对了。
 *   try{
 *       lock.lockInterruptibly();
 *       executeMethod();
 *   }finally{
 *      lock.unlock();
 *   }
 */
public class Normal {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        //线程t 调用testBlock()方法，获得了Normal类的锁，然后进入等待状态1000S,此时Normal类的锁被线程t持有
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    testBlock();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        t.start();

        //线程t1,调用test()方法，进入try语句块内，尝试获得Normal类的锁，但由于锁内线程t持有，此时t1只能等待，
        // 1S之后，主线程调用t1.interrupt()使得线程t1中断，lock.lockInterruptibly()方法抛出了InterruptedException异常，但由于
        //lock.lockInterruptibly()写在了try语句块中，所以lock.unlock()也会执行，由于t1一直没有获得Normal类的锁，，却要解锁，这是有问题的，
        // 会报java.lang.IllegalMonitorStateException异常
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    test();
                } catch (InterruptedException e) {
                    System.out.println("interruptedEx:" +e);
                }
            }
        };
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

    }

    public static void test() throws InterruptedException {
        try {
            lock.lockInterruptibly();
            System.out.println("test");
        } finally {
            lock.unlock();
        }
    }


    public static void testBlock() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println("enter sleep...");
            Thread.sleep(10000);
        } finally {
            lock.unlock();
        }
    }



}
