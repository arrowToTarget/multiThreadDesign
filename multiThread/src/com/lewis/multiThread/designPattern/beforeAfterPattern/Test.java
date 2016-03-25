package com.lewis.multiThread.designPattern.beforeAfterPattern;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangminghua on 2016/3/25.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " this is a runnable...");
            }
        };

        Thread t1 = new Thread(r);
        t1.setName("t1");
        t1.start();
        Thread.sleep(400);
        System.out.println("==============");
        Thread t = new Thread(r){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" this is a thread");
            }
        };
        t.setName("t");
        t.start();

        Map<String,String> map = new HashMap<String,String>();
        map.put(null,null);
        System.out.println(map.containsValue(null));
    }

}
