package com.lewis.guava;

import com.google.common.collect.HashBiMap;

/**
 * Created by zhangminghua on 2016/6/28.
 */
public class BiMapDemo {
    public static void main(String[] args) {
        HashBiMap<String , String> weekNameMap = HashBiMap.create();
        weekNameMap.put("星期一","Monday");
        weekNameMap.put("星期二","Tuesday");
        weekNameMap.put("星期三","Wednesday");
        weekNameMap.put("星期四","Thursday");
        weekNameMap.put("星期五","Friday");
        weekNameMap.put("星期六","Saturday");
        weekNameMap.put("星期日","Sunday");
        System.out.println("星期一的英文是："+weekNameMap.get("星期一"));
        System.out.println("Monday的中文是："+weekNameMap.inverse().get("Monday"));
        System.out.println("星期五的英文是："+weekNameMap.get("星期五"));
    }
}
