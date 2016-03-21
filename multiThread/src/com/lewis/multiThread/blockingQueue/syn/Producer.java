package com.lewis.multiThread.blockingQueue.syn;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadFactory;

/**
 * Created by zhangminghua on 2016/3/21.
 */
public class Producer {
    private final MyBlockingQueue queue;

    private Random random = new Random();

    public Producer(MyBlockingQueue queue) {
        this.queue = queue;
    }

    public void createRequest(int requestNumber){
        for (int i = 1; i <= requestNumber; i++) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
            Request request = new Request(i,"request_"+i, Thread.currentThread().getName());
            //System.out.println(Thread.currentThread().getName()+" put before queue size :" +queue.size());
            queue.put(request);
            System.out.println(Thread.currentThread().getName() +" produce : "+request.toString() +" put after queue size :" +queue.size() +" time:"+ Test.sdf.format(new Date()));

        }
    }

}
