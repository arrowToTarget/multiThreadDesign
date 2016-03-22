package com.lewis.multiThread.readWriteLock;


import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by zhangminghua on 2016/3/22.
 */
public class WriterTask implements Runnable{

    private String writeLetters;

    private final Data data;

    private int index;

    public WriterTask(String writeLetters, Data data) {
        this.writeLetters = writeLetters;
        this.data = data;
    }

    private boolean terimated = false;

    @Override
    public void run() {
        while (!terimated) {
            char letter = getNextChar();
            try {
                data.write(letter);
                System.out.println(Thread.currentThread().getName()+" write letter : "+letter);
            } catch (InterruptedException e) {
                terimated = true;
                System.out.println(Thread.currentThread().getId()+" enter interruptedException...");
            }
        }
    }

    public char getNextChar() {
        char letter = writeLetters.charAt(index);
        index = (++index)%writeLetters.length();
        return letter;
    }
}
