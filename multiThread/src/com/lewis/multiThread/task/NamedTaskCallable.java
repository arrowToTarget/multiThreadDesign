package com.lewis.multiThread.task;


/**
 * Created by zhangminghua on 2016/3/14.
 * 抽象标记性任务
 */
public interface NamedTaskCallable<T> extends TaskCallable<T> {

    String name();
}
