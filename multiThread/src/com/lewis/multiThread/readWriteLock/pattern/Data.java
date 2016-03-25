package com.lewis.multiThread.readWriteLock.pattern;


/**
 * Created by zhangminghua on 2016/3/23.
 */
public class Data {
    private final ReadWriteLock lock;

    private final ReadWriteStrategy readWriteStrategy;

    public Data() {
        this.lock = new ReadWriteLock(new DefaultGuardStrategy());
        this.readWriteStrategy = new DefaultReadWriteStrategy();
    }
    public Data(GuardStrategy guardStrategy) {
        this.lock = new ReadWriteLock(guardStrategy);
        this.readWriteStrategy = new DefaultReadWriteStrategy();
    }

    public Data(ReadWriteStrategy readWriteStrategy) {
        this.readWriteStrategy = readWriteStrategy;
        this.lock = new ReadWriteLock(new DefaultGuardStrategy());
    }

    public Data(GuardStrategy guardStrategy, ReadWriteStrategy readWriteStrategy) {
        this.lock = new ReadWriteLock(guardStrategy);
        this.readWriteStrategy = readWriteStrategy;
    }

    public Object read() throws InterruptedException{
        lock.readLock();
        try {
            return readWriteStrategy.doRead();
        } finally {
            lock.readUnLock();
        }
    }

    public void write(Object obj) throws InterruptedException{
        lock.writeLock();
        try {
            readWriteStrategy.doWrite(obj);
        } finally {
            lock.writeUnLock();
        }
    }

    private class ReadWriteLock {

        private final GuardStrategy guardStrategy;

        public ReadWriteLock(GuardStrategy guardStrategy) {
            this.guardStrategy = guardStrategy;
        }

        public synchronized void readLock() throws InterruptedException {
            guardStrategy.beforeReadWait();
            try {
                while (!guardStrategy.readGuard()) {
                    wait();
                }
            } finally {
                guardStrategy.afterReadWait();
            }
            guardStrategy.beforeDoRead();
        }

        public synchronized void readUnLock() throws InterruptedException {
            guardStrategy.afterDoRead();
            notifyAll();
        }

        public synchronized void writeLock() throws InterruptedException {
            guardStrategy.beforeWriteWait();
            try {
                while (!guardStrategy.writeGuard()) {
                    wait();
                }
            } finally {
                guardStrategy.afterWriteWait();
            }
            guardStrategy.beforeDoWrite();
        }

        public synchronized void writeUnLock() throws InterruptedException {
            guardStrategy.afterDoWrite();
            notifyAll();
        }
    }

    private class DefaultGuardStrategy implements GuardStrategy {
        private int readingReaders;
        private int waitingWriters;
        private int writingWriters;
        private boolean isPreferWriter = true;

        @Override
        public void beforeReadWait() {
            //no operation
        }

        @Override
        public boolean readGuard() {
            return !(writingWriters > 0 || (isPreferWriter && waitingWriters > 0));
        }

        @Override
        public void afterReadWait() {
            //no operation
        }

        @Override
        public void beforeDoRead() {
            readingReaders++;
        }

        @Override
        public void afterDoRead() {
            readingReaders--;
            isPreferWriter = true;
        }

        @Override
        public void beforeWriteWait() {
            waitingWriters++;
        }

        @Override
        public boolean writeGuard() {
            return !(readingReaders > 0 || writingWriters > 0);
        }

        @Override
        public void afterWriteWait() {
            waitingWriters--;
        }

        @Override
        public void beforeDoWrite() {
            writingWriters++;
        }

        @Override
        public void afterDoWrite() {
            writingWriters--;
            isPreferWriter = false;
        }
    }

    private class DefaultReadWriteStrategy implements ReadWriteStrategy {
        private final char[] buffer;

        public DefaultReadWriteStrategy() {
            this(10);
        }

        public DefaultReadWriteStrategy(int size) {
            buffer = new char[size];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = '*';
            }
        }


        @Override
        public Object doRead() throws InterruptedException {
            char[] newBuffer = new char[buffer.length];
            System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
            slowly();
            return newBuffer;
        }

        @Override
        public void doWrite(Object args) throws InterruptedException {
            char c = ((Character) args).charValue();
            for (int i = 0; i < buffer.length; i++) {
                slowly();
                buffer[i] = c;
            }
        }

        private void slowly() throws InterruptedException {
            Thread.sleep(50);
        }
    }
}
