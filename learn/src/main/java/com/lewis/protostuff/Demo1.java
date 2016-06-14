package com.lewis.protostuff;


import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by zhangminghua on 2016/6/13.
 */
public class Demo1 {

    public static void main(String[] args) {
        String str = null;
        ResponseVo responseVo = JSON.parseObject(str, ResponseVo.class);
        System.out.println(responseVo.toString());

    }

    private static void test1() {
        List<Person> personList = createPerson();
        long beginTime = System.currentTimeMillis();
        for (Person person:personList){
            String key="key_"+person.getId();
            CacheUtil.setCache(key,person);
            Person person1 = CacheUtil.getCache(key, Person.class);
            System.out.println(person1.toString());
        }
        System.out.println("noramlCache costTime ="+(System.currentTimeMillis()-beginTime));
        System.out.println("====================");
        beginTime = System.currentTimeMillis();
        for (Person person : personList) {
            String key="key_"+person.getId();
            CacheUtil.setCacheBytes(key,person);
            Person person2 = CacheUtil.getCacheBytes(key, Person.class);
            System.out.println(person2.toString());
        }
        System.out.println("getCacheBytes costTime ="+(System.currentTimeMillis()-beginTime));
    }

    public static List<Person> createPerson(){
        List<Person> list = new LinkedList<Person>();
        for (int i = 0; i < 100; i++) {
            list.add(new Person(i,"lewis_"+i,"2016-06-13 :"+i,i*2.234, Arrays.asList("dance_"+i,"running_"+i,"singing_"+i)));
        }
        return list;
    }

}
