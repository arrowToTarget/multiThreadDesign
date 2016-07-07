package com.lewis.guava.eventBus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by zhangminghua on 2016/6/28.
 */
public class MessageScreen {

    @Subscribe
    public void printMsg(String msg){
        System.out.println(msg);
    }
}
