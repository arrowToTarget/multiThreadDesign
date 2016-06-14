package com.lewis.collection;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zhangminghua on 2016/4/6.
 */
public class SystemProperty {
    public static void main(String[] args) {
      /*  Properties properties = System.getProperties();
        Iterator<Map.Entry<Object, Object>> it = properties.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Object> entry = it.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }*/

      Person p = new Person(100,"lewis","male",new Date());
        Object obj = p;
        System.out.println(p);

        Person pp = Person.class.cast(obj);
        System.out.println(pp);
    }

    static class  Person{
        private int id;
        private String name;
        private String sex ;
        private Date birthday;

        public Person(int id, String name, String sex, Date birthday) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", birthday=" + birthday +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }
    }
}
