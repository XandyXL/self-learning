package com.xandy.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author
 * @version 1.0
 * @date 2018/8/28 10:59 ´´½¨
 */
public class ReentantLockTest implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int count  = 0;

    @Override
    public void run() {
        for (int i = 0;i < 10000;i++) {
            lock.lock();
            try{
                count++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentantLockTest lockTest = new ReentantLockTest();
        Thread t1 = new Thread(lockTest);
        Thread t2 = new Thread(lockTest);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
