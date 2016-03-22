package com.lewis.multiThread.designPattern.guardedSuspension;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2016/3/22.
 * 负责对执行guardedMethod方法的线程进行挂起和唤醒，并执行ConcreteGuardedAction所实现的目标操作
 */
public interface Blocker {

    /**
     * 在保护条件成立时执行目标动作；否则阻塞当前线程，直到保护条件成立
     * @param guardedAction
     * @return
     * @throws Exception
     */
    <V>  V callWithGuard(GuardedAction<V> guardedAction) throws Exception;

    /**
     * 执行stateOperation所指定的目标操作后，决定是否唤醒本Blocker所暂挂的所有线程中的一个线程
     * @param stateOperation
     * @throws Exception
     */
    void signalAfter(Callable<Boolean> stateOperation) throws Exception;

    /**
     * 负责唤醒由该方法所属的Blocker实例所暂挂的线程中的一个线程
     * @throws InterruptedException
     */
    void signal() throws InterruptedException;

    /**
     * 执行stateOperation所指定的目标操作后，决定是否唤醒本Blocker所暂挂的所有线程
     * @param stateOperation
     * @throws Exception
     */
    void broadCastAfter(Callable<Boolean> stateOperation) throws Exception;
}
