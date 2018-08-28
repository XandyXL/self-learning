package com.xandy.thread.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 重复锁还好搭档 conditon条件
 *
 * @version 1.0
 * @date 2018/8/28 16:49 创建
 */
public class ReenterLockConditon implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    // 获取与lock绑定的condition
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            // 线程等待 并释放锁
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockConditon reenterLockConditon = new ReenterLockConditon();
        Thread t1 = new Thread(reenterLockConditon);
        t1.start();
        Thread.sleep(1000);
        // 唤醒线程，唤醒前需获取锁，唤醒后需释放锁，否则会导致唤醒的线程拿不到锁，导致饥饿,可通过注销掉39行代码验证
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
