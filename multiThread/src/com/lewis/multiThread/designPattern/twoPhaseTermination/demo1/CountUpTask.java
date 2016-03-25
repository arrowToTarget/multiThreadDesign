package com.lewis.multiThread.designPattern.twoPhaseTermination.demo1;

import java.io.*;

/**
 * Created by zhangminghua on 2016/3/24.
 */
public class CountUpTask implements Runnable {

    private volatile boolean shutdownRequested = false;

    private int count ;
    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    public void shutdownRequest() {
        shutdownRequested = true;
        System.out.println("invoke shutdownRequest Thread:"+Thread.currentThread().getName());
        //Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        try {
            while (!shutdownRequested) {
                doWork();
            }
        } catch (InterruptedException e) {
            System.out.println("CountUp interrupt :"+Thread.currentThread().getName());
            shutdownRequested = true;
        }finally {
            doShutdown();
        }
    }

    private void doShutdown() {
        final int number = count;
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(new File("D:\\1.txt"));
                    fos.write(String.valueOf(number).getBytes());
                } catch (FileNotFoundException e) {

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fos.close();
                    } catch (IOException e) {

                    }
                }
            }
        });
        System.out.println("clean up");
        System.out.println("doShutdown count: "+count);
    }

    private void doWork() throws InterruptedException {
        count++;
        System.out.println("doWork count: "+count);
        Thread.sleep(100);

    }
}
