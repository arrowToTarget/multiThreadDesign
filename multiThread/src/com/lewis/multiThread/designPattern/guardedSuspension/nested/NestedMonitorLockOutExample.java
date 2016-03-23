package com.lewis.multiThread.designPattern.guardedSuspension.nested;

import com.lewis.multiThread.designPattern.guardedSuspension.Blocker;
import com.lewis.multiThread.designPattern.guardedSuspension.ConditionVarBlocker;
import com.lewis.multiThread.designPattern.guardedSuspension.GuardedAction;
import com.lewis.multiThread.designPattern.guardedSuspension.Predict;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/3/22.
 */
public class NestedMonitorLockOutExample {
    public static void main(String[] args) {
        final Helper helper = new Helper();
        System.out.println("Before calling guardedMethod.");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String result ;
                result = helper.xGuardedMethod("test");
                System.out.println("result : "+result);
            }
        });
        t.setName("xGuardedMethod Thread");
        t.start();
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                helper.xStateChanged();
                timer.cancel();
            }
        },50,10);
    }

    private static class Helper{
        private volatile boolean isStateOK = false;

        private Predict predict = new Predict() {
            @Override
            public boolean evaluate() {
                return isStateOK;
            }
        };
        private Lock lock = new ReentrantLock();
        private Blocker blocker = new ConditionVarBlocker(lock);



        public  String xGuardedMethod(final String message){
            lock.lock();
            try {
                    GuardedAction<String> guardedAction = new GuardedAction<String>(predict) {
                        @Override
                        public String call() throws Exception {
                            return message + " -> received.";
                        }
                    };
                    String result = null;
                    try {
                        result = blocker.callWithGuard(guardedAction);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return result;
            } finally {
                lock.unlock();
            }

        }

        public  void xStateChanged(){
            lock.lock();
            try {
                blocker.signalAfter(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        isStateOK = true;
                        System.out.println("state ok.");
                        return Boolean.TRUE;
                    }
                });
            } catch (Exception e) {

            }finally {
                lock.unlock();
            }
        }
    }
}
