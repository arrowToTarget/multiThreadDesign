package com.lewis.multiThread.designPattern.twoPhaseTermination;

import com.lewis.multiThread.designPattern.guardedSuspension.AlarmAgent;
import com.lewis.multiThread.designPattern.guardedSuspension.AlarmInfo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2016/3/23.
 * 角色模式：Two-Phase Termination.ConcreteTerminatableThread
 */
public class AlarmSendingThread extends AbstractTerminateThread {

    private final AlarmAgent alarmAgent = new AlarmAgent();

    //告警队列
    private final ArrayBlockingQueue<AlarmInfo> alarmQueue;

    private final ConcurrentHashMap<String,AtomicInteger> submittedAlarmRegistry;
    public AlarmSendingThread(){
        alarmQueue = new ArrayBlockingQueue<AlarmInfo>(100);
        this.submittedAlarmRegistry = new ConcurrentHashMap<String, AtomicInteger>();
        alarmAgent.init();
    }
    @Override
    protected void doRun() throws Exception {

    }
}
