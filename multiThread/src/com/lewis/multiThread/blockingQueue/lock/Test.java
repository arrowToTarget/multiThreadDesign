package com.lewis.multiThread.blockingQueue.lock;



import java.text.SimpleDateFormat;

/**
 * Created by zhangminghua on 2016/3/21.
 */
public class Test {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ssSSS");

    public static void main(String[] args) {
        final BlockingQueue queue = new BlockingQueue(20);

       Thread pA=  new Thread(){
            @Override
            public void run() {
                new Producer(queue).createRequest(25);
            }
        };
        pA.setName("Producer_A");
        pA.start();


        Thread pB=  new Thread(){
            @Override
            public void run() {
                new Producer(queue).createRequest(25);
            }
        };
        pB.setName("Producer_B");
        pB.start();

        Thread pC=  new Thread(){
            @Override
            public void run() {
                new Producer(queue).createRequest(25);
            }
        };
        pC.setName("Producer_C");
        pC.start();

        Thread cA = new Thread(){
            @Override
            public void run() {
                new Consumer(queue).processRequest();
            }
        };
        cA.setName("Consumer_A");
        cA.start();

        Thread cB = new Thread(){
            @Override
            public void run() {
                new Consumer(queue).processRequest();
            }
        };
        cB.setName("Consumer_B");
        cB.start();
    }


}
