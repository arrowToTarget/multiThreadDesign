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

    public void createRequest(int requestNumber){
        for (int i = 1; i <= requestNumber; i++) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
            Request request = new Request(i,"request_"+i, Thread.currentThread().getName());
            try {
                queue.put(request);
            } catch (InterruptedException e) {
                //do process
            }
            System.out.println(Thread.currentThread().getName() +" produce : "+request.toString() +" put after queue size :" +queue.size() +" time:"+ Test.sdf.format(new Date()));

        }
    }

}
