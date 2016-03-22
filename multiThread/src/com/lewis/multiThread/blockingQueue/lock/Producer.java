package com.lewis.multiThread.blockingQueue.lock;

import com.lewis.multiThread.blockingQueue.Request;
import com.lewis.multiThread.blockingQueue.syn.Test;

import java.util.Date;
import java.util.Random;

/**
 * Created by zhangminghua on 2016/3/21.
 */
public class Producer {
    private final BlockingQueue queue;

    private Random random = new Random();

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    private boolean termiated = false;

    public void createRequest(){
        int i = 0;
        while (!termiated) {
            try {
                Thread.sleep(random.nextInt(1000));
                i++;
                Request request = new Request(i,"request_"+i, Thread.currentThread().getName());
                queue.put(request);
                System.out.println(Thread.currentThread().getName() +" produce : "+request.toString() +" put after queue size :" +queue.size() +" time:"+ Test.sdf.format(new Date()));
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+ " enter interruptedException");
                termiated = true;
            }
        }

    }

}
