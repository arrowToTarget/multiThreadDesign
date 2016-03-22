package com.lewis.multiThread.designPattern.guardedSuspension;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2016/3/22.
 * 抽象了目标动作，并关联了目标动作所需要的保护条件
 */
public abstract class GuardedAction<V> implements Callable<V> {

    protected final Predict predict;

    public GuardedAction(Predict predict){
        this.predict = predict;
    }

}
