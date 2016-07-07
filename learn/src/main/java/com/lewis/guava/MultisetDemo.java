package com.lewis.guava;

import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by zhangminghua on 2016/6/28.
 */
public class MultisetDemo {
    public static void main(String[] args) {

        HashMultiset<String> multiset = HashMultiset.create();
        String sentences = "this is a story, there is a good girl in the story.";
        Iterable<String> it = Splitter.onPattern("[^a-z]{1,}").omitEmptyStrings().trimResults().split(sentences);
        for (String word : it) {
            multiset.add(word);
        }
        for (Object element : multiset.elementSet()) {
            System.out.println(element+" count :"+multiset.count(element));
        }
    }
}
