package com.xandy.thread.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: �ظ������ô conditon����
 *
 * @version 1.0
 * @date 2018/8/28 16:49 ����
 */
public class ReenterLockConditon implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    // ��ȡ��lock�󶨵�condition
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            // �̵߳ȴ� ���ͷ���
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
        // �����̣߳�����ǰ���ȡ�������Ѻ����ͷ���������ᵼ�»��ѵ��߳��ò����������¼���,��ͨ��ע����39�д�����֤
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
