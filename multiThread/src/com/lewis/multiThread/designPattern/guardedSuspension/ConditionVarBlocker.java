package com.lewis.multiThread.designPattern.guardedSuspension;


import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/3/22.
 * 基于java的条件变量Conditon实现的Blocker
 */
public class ConditionVarBlocker implements Blocker {
    private final Lock lock;

    private final Condition condition;

    public ConditionVarBlocker(Lock lock) {
        this.lock = lock;
        this.condition = lock.newCondition();
    }

    public ConditionVarBlocker() {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }


    @Override
    public <V> V callWithGuard(GuardedAction<V> guardedAction) throws Exception {
        lock.lockInterruptibly();
        try {
            Predict predict = guardedAction.predict;
            while (!predict.evaluate()) {
                condition.await();
            }
            return guardedAction.call();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void signalAfter(Callable<Boolean> stateOperation) throws Exception {
        lock.lockInterruptibly();
        try {
            if (stateOperation.call()) {
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void signal() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void broadCastAfter(Callable<Boolean> stateOperation) throws Exception {
        lock.lockInterruptibly();
        try {
            if (stateOperation.call()) {
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
