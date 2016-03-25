package com.lewis.multiThread.readWriteLock.pattern;

/**
 * Created by zhangminghua on 2016/3/24.
 */
public class Test {

    public static void main(String[] args) {
        Data data = new Data();

        Thread read_1 = new Thread(new ReaderTask(data));
        read_1.setName("read_1");
        read_1.start();

        Thread read_2 = new Thread(new ReaderTask(data));
        read_2.setName("read_2");
        read_2.start();

        Thread read_3 = new Thread(new ReaderTask(data));
        read_3.setName("read_3");
        read_3.start();


        Thread write_1 = new Thread(new WriterTask("abcdefghijklmnopqrstuvwsyz",data));
        write_1.setName("write_1");
        write_1.start();
        Thread write_2 = new Thread(new WriterTask("ABCDEFGHIJKLMNOPQRSTUVWSYZ",data));
        write_2.setName("write_2");
        write_2.start();




    }
}
