package com.xandy.thread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: ��ƽ��
 *
 * @author
 * @version 1.0
 * @date 2018/8/28 16:23 ����
 */
public class FairLock implements Runnable {
    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            // ��ƽ�����ȴ����������λ�ȡ��
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "�����");
            } finally {
                fairLock.unlock();
            }
//            TODO ��ʱ��Ȼ���˹�ƽ�������ǵ���tryLock  ����ͽ����ո��ͷ����Ľ��̣��� ��ƽ����tryLockʧЧ
//            if (fairLock.tryLock()) {
//                try {
//                    System.out.println(Thread.currentThread().getName() + "�����");
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
