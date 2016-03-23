package com.lewis.multiThread.readWriteLock.pattern;

/**
 * Created by zhangminghua on 2016/3/23.
 */
public interface GuardStrategy {
    void beforeReadWait();

    boolean readGuard();

    void afterReadWait();

    void beforeDoRead();

    void afterDoRead();

    void beforeWriteWait();
    boolean writeGuard();
    void afterWriteWait();
    void  beforeDoWrite();
    void afterDoWrite();

}
