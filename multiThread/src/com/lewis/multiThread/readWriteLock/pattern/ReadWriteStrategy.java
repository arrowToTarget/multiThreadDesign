package com.lewis.multiThread.readWriteLock.pattern;

/**
 * Created by zhangminghua on 2016/3/23.
 */
public interface ReadWriteStrategy {
    Object doRead() throws InterruptedException;

    void doWrite(Object args) throws InterruptedException;
}
