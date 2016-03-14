package com.lewis.multiThread.task;

/**
 * Created by zhangminghua on 2016/3/14.
 * 抽象任务回调
 */
public interface TaskCallable<T> {

      T doCallable() throws Exception;
}
