package com.lewis.guava;


import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.*;

import java.util.*;

/**
 * Created by zhangminghua on 2016/6/27.
 */
public class GuavaTest {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        List<String> fruitList = Arrays.asList("apple", "banana", "orange", "apple", "apple", "banana", "peach");
        Multiset<String> set = ImmutableMultiset.copyOf(fruitList.iterator());
        System.out.println(set.count("apple"));
        System.out.println(set.count("banana"));
        System.out.println(set.count("orange"));
        System.out.println(set.count("peach"));
        System.out.println(set.count("hhe"));
        System.out.println(set.size());
        System.out.println(set.elementSet().size());
        Set<String> strings = set.elementSet();
        LinkedList<String> list = Lists.newLinkedList();
        for (int i = 0; i < 10; i++) {
            list.add("name_+" + i);
        }
    }

    public static Optional<String> getName(String alias) {
        Optional<String> name = Optional.fromNullable(alias);
        return name;
    }

    public static void test2() {
        LinkedListMultimap<String, String> multimap = LinkedListMultimap.create(64);
        multimap.put("fruit", "apple");
        multimap.put("fruit", "banana");
        multimap.put("fruit", "orange");
        multimap.put("fruit", "peach");
        multimap.put("vegetables", "watermalon");
        multimap.put("vegetables", "cucumber");
        List<String> fruits = multimap.get("fruit");
        System.out.println(fruits.toString()+" size:"+fruits.size());
        System.out.println(multimap.get("vegetables").toString()+" size:"+multimap.get("vegetables").size());
        System.out.println(multimap.get("car").toString()+" size:"+multimap.get("car").size());

    }

    public static void test3() {
        Optional<String> name = getName(null);
        if (name.isPresent()) {
            String s = name.get();
            System.out.println(s);
        }
        Optional<String> absent = name.absent();
        if (absent.isPresent()) {
            System.out.println(absent.get());
        }
        Objects.equal("a", "a");
    }
}
