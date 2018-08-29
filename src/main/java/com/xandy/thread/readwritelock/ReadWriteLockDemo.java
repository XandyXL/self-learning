package com.xandy.thread.readwritelock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description:
 *
 * @author
 * @version 1.0
 * @date 2018/8/28 17:58 创建
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    /**
     * 读操作
     *
     * @param lock
     * @return
     * @throws InterruptedException
     */
    private int handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            // 模拟读耗时，读耗时越多，越能体现使用读写锁的效率高
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 写操作
     *
     * @param lock
     * @param value
     * @throws InterruptedException
     */
    private void handleWrite(Lock lock, int value) throws InterruptedException {
        try {
            lock.lock();
            // 模拟写耗时
            Thread.sleep(1000);
            this.value = value;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();

        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);
//                    demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(writeLock, new Random().nextInt());
//                    demo.handleWrite(lock,new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 读写线程共20个 用读写锁耗时2秒左右，用68、80行耗时20秒
        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 18; i < 20; i++) {
            new Thread(writeRunnable).start();
        }
    }
}
