package com.lewis.multiThread.designPattern.twoPhaseTermination.demo1;

/**
 * Created by zhangminghua on 2016/3/24.
 */
public class Test {
    public static void main(String[] args) {
        final CountUpTask countUpTask = new CountUpTask();
        Thread t = new Thread(countUpTask);
        t.setName("CountUpThread");
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("thread t.method has been invoked.");
        //countUpTask.shutdownRequest();
        t.interrupt();


    }
}
