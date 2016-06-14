package com.lewis.collection;

import java.util.*;

/**
 * Created by zhangminghua on 2016/4/2.
 */
public class HashDemo {


    private final int[] table;

    public HashDemo(int size) {
        this.table = new int[size];
        for (int i = 0; i < size; i++) {
            table[i] = i;
        }
    }

    //求key所对应的在数组中的位置
    public int index(int key){
        //求hash值
        int hash = hash(key);
        //返回key所对应的在数组中的位置
        return hash & (table.length-1);
    }


    //HashMap中hash函数的实现,求hash值
    public int hash(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }


    public static void main(String[] args) {
        Map<String,Integer> keyToNumber = new HashMap<String, Integer>();
        int size = 50;
        HashDemo hashDemo = new HashDemo(size);
        int testSize = 1000;
        for (int i = 0; i < testSize; i++) {
            int index = hashDemo.index(i);
            Integer number = keyToNumber.get("key" + index);
            if (number == null) {
                keyToNumber.put("key"+index,1);
            }else {
                keyToNumber.put("key"+index,keyToNumber.get("key"+index)+1);
            }
        }
        Iterator<Map.Entry<String, Integer>> it = keyToNumber.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + "   == "+entry.getValue());
        }
    }

}
