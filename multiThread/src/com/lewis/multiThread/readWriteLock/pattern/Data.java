package com.lewis.multiThread.readWriteLock.pattern;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangminghua on 2016/3/23.
 */
public class Data {

    public static void main(String[] args) {
        List<Integer>  list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        List<Integer>  list1 = new LinkedList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(6);
        System.out.println(list);
        System.out.println(list1);
        System.out.println("==============");
        list.removeAll(list1);
        System.out.println(list);
        System.out.println(list1);
    }

    private class ReadWriteLock{
        private final GuardStrategy guardStrategy;

        public ReadWriteLock(GuardStrategy guardStrategy) {
            this.guardStrategy = guardStrategy;
        }



    }
}
