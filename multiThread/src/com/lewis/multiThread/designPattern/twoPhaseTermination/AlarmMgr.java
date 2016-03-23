package com.lewis.multiThread.designPattern.twoPhaseTermination;


/**
 * Created by Administrator on 2016/3/23.
 */
public class AlarmMgr {
    private static AlarmMgr instance = new AlarmMgr();

    public static AlarmMgr getInstance(){
        return instance;
    }

    private volatile boolean shutdownRequested = false;


}
