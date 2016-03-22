package com.lewis.multiThread.readWriteLock;


public class ReadWriterLock {
    //获取了读锁，但尚未释放读锁的线程数
    private int readingReaders;
    //等待获取写锁的线程数
    private int waitingWriters;
    //获取了写锁，但尚未释放写锁的线程数
    private int writingWriters;
    //是否写线程优先
    private boolean preferWriter = true;

    //获取读锁
    public synchronized void readLock() throws InterruptedException {
        //若有线程获取了写锁但尚未释放，或者preferWriter=true并且等待获取写锁的线程数>0,
        //则当前线程必须等待，否则会产生读写冲突read-write conf;oct
        while (writingWriters > 0 || (waitingWriters > 0 && preferWriter)) {
            wait();
        }
        //程序走到这，说明了此时共享资源上没有线程竞争，可以直接获取读锁，将readingReaders+1
        readingReaders ++;
    }

    //释放读锁
    public synchronized void readUnLock(){
        //readingReaders-1
        readingReaders--;
        //读完之后，该写了
        preferWriter = true;
        //通知其他线程 当前线程已经释放读锁，让其他等待获取监视器的线程可以获取相应的锁了
        notifyAll();
    }

    //获取写锁
    public synchronized void writeLock() throws InterruptedException {
        //将等待获取锁定的线程数+1
        waitingWriters++;
        try {
            //当有线程获取读锁的时候，会产生read-write conflict;当有线程获取写锁的时候，会产生write-write conflict,所以此时必须等待
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            //将等待获取锁定的线程数-1
            waitingWriters--;
        }
        //将获取写锁的线程数+1
        writingWriters++;
    }

    //释放写锁
    public synchronized void writeUnLock(){
        //将获取写锁的线程数-1
        writingWriters--;
        //写完，该读了
        preferWriter = false;
        //通知其他线程，当前线程即将释放写锁；让其他正在等待获取相关锁的线程去竞争资源吧
        notifyAll();
    }
}
