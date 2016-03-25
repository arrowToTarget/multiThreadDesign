package com.lewis.multiThread.readWriteLock.pattern;

/**
 * Created by zhangminghua on 2016/3/24.
 */
public class ReaderTask implements Runnable {

    private final Data data;

    public ReaderTask(Data data) {
        this.data = data;
    }

    private boolean terminated = false;

    @Override
    public void run() {
        while (!terminated){
            try {
                char[] charArray = (char[]) data.read();
                System.out.println(Thread.currentThread().getName()+" read content :"+new String(charArray));
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" enter interruptedException...");
                terminated = true;
            }
        }
    }
}
