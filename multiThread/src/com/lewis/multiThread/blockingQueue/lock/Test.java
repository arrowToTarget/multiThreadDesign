package com.lewis.multiThread.blockingQueue.lock;



import java.text.SimpleDateFormat;


public class Test {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ssSSS");

    public static void main(String[] args) {
        final BlockingQueue queue = new BlockingQueue(20);

       Thread pA=  new Thread(){
            @Override
            public void run() {
                new Producer(queue).createRequest();
            }
        };
        pA.setName("Producer_A");
        pA.start();
        Thread.State state = pA.getState();


        Thread pB=  new Thread(){
            @Override
            public void run() {
                new Producer(queue).createRequest();
            }
        };
        pB.setName("Producer_B");
        pB.start();

        Thread pC=  new Thread(){
            @Override
            public void run() {
                new Producer(queue).createRequest();
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
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
        System.out.println("begin interrupt");
        pA.interrupt();
        pB.interrupt();
        pC.interrupt();
        cA.interrupt();
        cB.interrupt();


/*       Thread clearThread=  new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    if (queue.size() == 20) {
                        System.out.println("queue size reached threshold : begin clear method...");
                        queue.clear();
                        System.out.println("queue size reached threshold : after clear method...");
                    }
                }
            }
        };
        clearThread.setName("clearThread ");
        clearThread.start();*/


    }


}
