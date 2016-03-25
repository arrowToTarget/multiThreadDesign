package com.lewis.multiThread.readWriteLock.pattern;

/**
 * Created by zhangminghua on 2016/3/24.
 */
public class WriterTask implements Runnable{
    private final Data data;
    private int index ;
    private final String letters;
    private boolean terminted = false;
    public WriterTask(String letters,Data data) {
        this.letters = letters;
        this.data = data;
    }

    @Override
    public void run() {
        while (!terminted) {
            char nextChar = getNextChar();
            try {
                data.write(nextChar);
                System.out.println(Thread.currentThread().getName()+" write letter: "+nextChar);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" enter interruptedException ...");
                terminted = true;
            }
        }
    }

    public synchronized  char getNextChar(){
        char c = letters.charAt(index);
        index = (++index)%letters.length();
        return c;
    }
}
