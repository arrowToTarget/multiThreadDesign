package com.lewis.multiThread.task;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhangminghua on 2016/3/14.
 */
public class TaskProcessorTest {
    public static void main(String[] args) {
        final Random random = new Random();
        List<TaskCallable<Integer>> list = new LinkedList<TaskCallable<Integer>>();
        for (int i = 0; i < 100; i++) {
            final int j = i;
            list.add(new TaskCallable<Integer>() {
                private final int index = j;
                @Override
                public Integer doCallable() throws Exception {
                    Thread.sleep(random.nextInt(1));
                   //. System.out.println("task before index : "+index);
                    try {
                        return random.nextInt(100)+random.nextInt(100);
                    } finally {
                        System.out.println("task after index : "+index);
                    }
                }
            });
        }
        TaskProcessor taskProcessor = new TaskProcessor(8, 10);
        List<Integer> integers = taskProcessor.executeTaskConcurrent( list,8);
        System.out.println(integers);
    }
}
