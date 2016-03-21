package com.lewis.multiThread.blockingQueue.syn;

import java.util.Date;
import java.util.Random;

/**
 * Created by zhangminghua on 2016/3/21.
 */
public class Consumer {
    private final MyBlockingQueue queue;

    private Random random = new Random();

    public Consumer(MyBlockingQueue queue) {
        this.queue = queue;
    }

    public void processRequest(){
        while (true) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
            Request take = queue.take();
            System.out.println(Thread.currentThread().getName() +"consumer :"+take.toString()+" take after queue size :" +queue.size()+" time:"+Test.sdf.format(new Date()));


        }
    }
}
