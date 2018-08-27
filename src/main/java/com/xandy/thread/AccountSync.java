package com.xandy.thread;

/**
 * Description:
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/8/27 18:45 ����
 */
public class AccountSync implements Runnable {
    static final AccountSync instance = new AccountSync();
    static int count = 0;

    /**
     * ������ʵ�����������ڵ��ø÷���ǰ��Ҫ��ȡ�ö������
     */
    public synchronized void increate() {
        count++;
    }

    /**
     * �̲߳���ȫ
     */
    public void increateNoSync() {
        count++;
    }


    /**
     * ����ǰ��Ҫ��ȡ���������Ի���ʵ���̰߳�ȫ
     */
    public static synchronized void increateStaticSync() {
        count++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            increate();
            //increateNoSync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
