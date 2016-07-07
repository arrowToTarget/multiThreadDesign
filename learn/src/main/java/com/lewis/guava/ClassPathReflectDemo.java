package com.lewis.guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.IOException;

/**
 * Created by zhangminghua on 2016/6/28.
 */
public class ClassPathReflectDemo {
    public static void main(String[] args) throws IOException {
        ClassPath classPath = ClassPath.from(Thread.currentThread().getContextClassLoader());
        ImmutableSet<ClassPath.ClassInfo> topLevelClasses = classPath.getTopLevelClassesRecursive("com.lewis");
        for (ClassPath.ClassInfo classInfo : topLevelClasses) {
            System.out.println(classInfo.getName());
        }
    }
}
