package com.lewis.multiThread.designPattern.guardedSuspension;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2016/3/22.
 * 负责连接告警服务器，并发送告警信息到告警服务器
 */
public class AlarmAgent {
    //用于记录AlarmAgent是否连接上告警服务器
    private volatile boolean connectedToServer = false;

    //角色模式： GuardedSuspension.Predict
    private final Predict agentConnected = new Predict() {
        @Override
        public boolean evaluate() {
            return connectedToServer;
        }
    };

    //角色模式：GuardedSuspension.Blocker
    private final Blocker blocker = new ConditionVarBlocker();
    //心跳定时器
    private final Timer heartBeatTimer = new Timer(true);

    public void sendAlarm(final AlarmInfo alarmInfo) throws Exception{
        //可能需要等待，直到AlarmAgent连接上告警服务器（或者连接中断后重新连上服务器）
        GuardedAction<Void> guardedAction = new GuardedAction<Void>(agentConnected) {
            @Override
            public Void call() throws Exception {
                doSendAlarm(alarmInfo);
                return null;
            }
        };
        blocker.callWithGuard(guardedAction);
    }

    //通过网络连接将告警信息发送给告警服务器
    private void doSendAlarm(AlarmInfo alarmInfo) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            //do interruptedException process
        }
    }

    public void init(){
        //省略其他代码
        //告警连接线程
        Thread connectingThread = new Thread(new ConnectingTask());
        connectingThread.start();
        heartBeatTimer.schedule(new HeartBeatTask(),6000,2000);
    }

    public void disconnect(){
        connectedToServer = false;
    }

    protected void onConnected(){
        try {
            blocker.signalAfter(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    connectedToServer = true;
                    return Boolean.TRUE;
                }
            });
        } catch (Exception e) {
            //do exception process
        }

    }

    protected void onDisConnected(){
        connectedToServer = false;
    }

    //负责与告警服务器建立网络连接
    private class ConnectingTask implements Runnable{
        @Override
        public void run() {
            //省略其他代码
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
            onConnected();
        }
    }

    /**
     * 心跳定时任务：定时检查与告警服务器的连接是否正常，发现连接异常后自动重新连接
     */
    private class HeartBeatTask extends TimerTask{

        @Override
        public void run() {
            //省略其他代码
            if (!testConnection()) {
                onDisConnected();
                reconnected();
            }
        }

        private boolean testConnection(){
            //省略其他代码
            return true;
        }

        private void reconnected(){
            ConnectingTask connectingTask = new ConnectingTask();
            //直接在心跳定时器线程中执行
            connectingTask.run();
        }
    }


}
