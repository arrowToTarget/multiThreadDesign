package com.lewis.multiThread.readWriteLock;

/**
 * Created by zhangminghua on 2016/3/22.
 */
public class Data {

    private final char[] table;
    private ReadWriterLock lock = new ReadWriterLock();

    public Data(int count) {
        this.table = new char[count];
        initTable();
    }

    public char[] read() throws InterruptedException {
        lock.readLock();
        try {
            return doRead();
        } finally {
            lock.readUnLock();
        }
    }

    private char[] doRead() {
        char[] newTable = new char[table.length];
        System.arraycopy(table, 0, newTable, 0, table.length);
        slowly();
        return newTable;
    }

    public void write(char letter) throws InterruptedException {
        lock.writeLock();
        try {
            doWrite(letter);
        } finally {
            lock.writeUnLock();
        }
    }

    private void doWrite(char letter) {
        for (int i = 0; i < table.length; i++) {
            slowly();
            table[i] = letter;
        }
    }

    private void slowly(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            //sleep interrupted
        }
    }

    private void initTable() {
        for (int i = 0; i < table.length; i++) {
            table[i] = '*';
        }
    }
}
