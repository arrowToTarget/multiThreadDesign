package com.lewis.protostuff;

import java.util.List;

/**
 * Created by zhangminghua on 2016/6/13.
 */
public class Person {

    private int id;

    private String name;

    private String birthday;

    private double tall;

    private List<String> hobbys;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getTall() {
        return tall;
    }

    public void setTall(double tall) {
        this.tall = tall;
    }

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    public Person(int id, String name, String birthday, double tall, List<String> hobbys) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.tall = tall;
        this.hobbys = hobbys;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", tall=" + tall +
                ", hobbys=" + hobbys +
                '}';
    }
}
