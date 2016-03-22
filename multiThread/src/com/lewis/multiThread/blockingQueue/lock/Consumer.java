package com.lewis.multiThread.blockingQueue.lock;

import com.lewis.multiThread.blockingQueue.Request;
import com.lewis.multiThread.blockingQueue.syn.Test;

import java.util.Date;
import java.util.Random;

/**
 * Created by zhangminghua on 2016/3/21.
 */
public class Consumer {
    private final BlockingQueue queue;

    private Random random = new Random();

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    private boolean terimated = false;
    public void processRequest(){
        while (!terimated) {
            try {
                Thread.sleep(random.nextInt(1000));
                Request  take = queue.take();
                System.out.println(Thread.currentThread().getName() +"consumer :"+take.toString()+" take after queue size :" +queue.size()+" time:"+ Test.sdf.format(new Date()));
            } catch (InterruptedException e) {
                terimated = true;
                System.out.println(Thread.currentThread().getName()+" enter interruptedException");
            }
        }
    }
}
