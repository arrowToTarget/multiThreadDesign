package com.lewis.multiThread.readWriteLock;

/**
 * Created by zhangminghua on 2016/3/22.
 */
public class ReaderTask implements Runnable{

    private final Data data;

    public ReaderTask(Data data) {
        this.data = data;
    }

    private boolean terimated = false;

    @Override
    public void run() {
        while (!terimated) {
            try {
                char[] readContentChars = data.read();
                System.out.println(Thread.currentThread().getName()+" reader content :"+new String(readContentChars));
            } catch (InterruptedException e) {
                terimated = true;
                System.out.println(Thread.currentThread().getName()+" enter interruptedException...");
            }
        }
    }
}
