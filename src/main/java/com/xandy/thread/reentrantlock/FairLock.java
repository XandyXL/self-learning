package com.xandy.thread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 公平锁
 *
 * @author
 * @version 1.0
 * @date 2018/8/28 16:23 创建
 */
public class FairLock implements Runnable {
    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            // 公平锁，等待队列中依次获取锁
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                fairLock.unlock();
            }
//            TODO 此时虽然用了公平锁，但是调用tryLock  锁会就近给刚刚释放锁的进程，即 公平锁用tryLock失效
//            if (fairLock.tryLock()) {
//                try {
//                    System.out.println(Thread.currentThread().getName() + "获得锁");
//                } finally {
//                    fairLock.unlock();
//                }
//            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();

        Thread t1 = new Thread(fairLock,"thread_t1");
        Thread t2 = new Thread(fairLock,"thread_t2");

        t1.start();
        t2.start();
    }
}
