package com.xandy.thread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: tryLock 如果锁未被占用，就占用锁，如果占用则直接返回false，不会阻塞进程
 *
 * @author
 * @version 1.0
 * @date 2018/8/28 16:13 创建
 */
public class TryLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            if (lock == 1) {
                if (lock1.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getId() + " done");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            } else {
                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + " done");
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLock lock1 = new TryLock(1);
        TryLock lock2 = new TryLock(2);

        Thread t1 = new Thread(lock1);
        Thread t2 = new Thread(lock2);

        t1.start();
        t2.start();

    }
}
