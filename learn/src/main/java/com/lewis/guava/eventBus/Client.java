package com.lewis.guava.eventBus;

import com.google.common.eventbus.EventBus;

/**
 * Created by zhangminghua on 2016/6/28.
 */
public class Client {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new MessageScreen());
        eventBus.post("hello ! lewis！");
    }
}
