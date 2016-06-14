package com.lewis.collection;

import javax.swing.text.html.HTMLWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhangminghua on 2016/5/3.
 */
public class Utils {

    private static final Random random = new Random();

    public static int[] generateArray(int length,int maxNumber){
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(maxNumber);
        }
        return array;
    }

    public static  <T> List<T> getSpecifiedElementList(List<T> inputList, PreCondition condition){
        List<T> retList = new LinkedList<T>();
        for (T   t   : inputList) {
            if (condition.evaluated(t)) {
                retList.add(t);
            }
        }
        return retList;
    }

    public static <T> T getSpecifiedElement(List<T> inputList,PreCondition condition){
        for (T   t   : inputList) {
            if (condition.evaluated(t)) {
                return t;
            }
        }
        return null;
    }




    public static void main(String[] args) {
        while (true){
            List<SystemProperty.Person> list = new LinkedList<SystemProperty.Person>();
            list.add(new SystemProperty.Person(1,"张之洞","male",new Date()));
            list.add(new SystemProperty.Person(2,"张之洞","femle",new Date()));
            list.add(new SystemProperty.Person(2,"张文超","male",new Date()));
            list.add(new SystemProperty.Person(3,"张曼玉","male",new Date()));
            list.add(new SystemProperty.Person(5,"李世明","male",new Date()));
            list.add(new SystemProperty.Person(6,"李晓伟","male",new Date()));
            list.add(new SystemProperty.Person(7,"李晓雪","male",new Date()));
            final User u = new User("张之洞",2);
            PreCondition<SystemProperty.Person> preCondition = new PreCondition<SystemProperty.Person>() {
                @Override
                public boolean evaluated(SystemProperty.Person person) {
                    return person.getName().equals(u.getUserName());
                }
            };
            //List<SystemProperty.Person> specifiedElementList = getSpecifiedElementList(list, preCondition);
            //System.out.println(specifiedElementList);
            Iterator<SystemProperty.Person> it = list.iterator();
            while (it.hasNext()) {
                SystemProperty.Person person = it.next();
                System.out.println(person);
                it.remove();
                //continue;
                System.out.println(111);
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class User{
        private String userName;

        private int userId;

        public User(String userName, int userId) {
            this.userName = userName;
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", userId=" + userId +
                    '}';
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }


}
