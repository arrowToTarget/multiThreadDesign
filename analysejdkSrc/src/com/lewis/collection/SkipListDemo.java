package com.lewis.collection;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by zhangminghua on 2016/5/21.
 */
public class SkipListDemo {

    private static final Random r = new Random();

    public static void main(String[] args) {
        Set<Person> personSet = getPersonSet();
        System.out.println(personSet);
    }

    public static Set<Person> getPersonSet(){
        Set<Person> set = new HashSet<Person>();
        Set<Person> retListSet = new ConcurrentSkipListSet(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return new BigDecimal(o1.getScore()).compareTo(new BigDecimal(o2.getScore()));
            }
        });
        for (int i = 0; i < 100; i++) {
            Person person = new Person(i, "name_" + i, "male", r.nextDouble()*1000);
            retListSet.add(person);
            set.add(person);
        }
        System.out.println("set = "+set);
        return retListSet;
    }

}
