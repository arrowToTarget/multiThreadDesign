package com.lewis.multiThread.designPattern.twoPhaseTermination.demo1;


/**
 * Created by zhangminghua on 2016/3/24.
 */
public class BlockHole {
    public static void enter(Object object){
        System.out.println("step 1");
        magic(object);
        System.out.println("step 2");

        synchronized (object){
            System.out.println("step 3");
        }
    }

    private static void magic(final Object object) {
        new Thread(){
            @Override
            public void run() {
                synchronized (object){
                    try {
                        this.join();
                    } catch (InterruptedException e) {

                    }
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        final Object o = new Object();
        enter(o);
    }


}
