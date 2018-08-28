package com.xandy.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * TODO 中断响应与pdf不符 详见pdf，实战Java高并发程序设计.pdf page88 中断响应
 * @author
 * @version 1.0
 * @date 2018/8/28 11:31 创建
 */
public class IntLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    /**
     * 控制加锁顺序，方便造成死锁
     *
     * @param lock
     */
    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (lock == 1) {
                    lock1.lockInterruptibly();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e){

                    }
                    lock2.lockInterruptibly();
                }else {
                    lock2.lockInterruptibly();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                    }
                    lock1.lockInterruptibly();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntLock intLock1 = new IntLock(1);
        IntLock intLock2 = new IntLock(2);
        Thread t1 = new Thread(intLock1);
        Thread t2 = new Thread(intLock2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        //中断一个线程
        t2.interrupt();


    }
}
