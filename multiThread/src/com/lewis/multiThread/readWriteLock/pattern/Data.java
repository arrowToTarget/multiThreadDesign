package com.lewis.multiThread.readWriteLock.pattern;

/**
 * Created by zhangminghua on 2016/3/23.
 */
public class Data {


    private class ReadWriteLock{
        private final GuardStrategy guardStrategy;

        public ReadWriteLock(GuardStrategy guardStrategy) {
            this.guardStrategy = guardStrategy;
        }



    }
}
