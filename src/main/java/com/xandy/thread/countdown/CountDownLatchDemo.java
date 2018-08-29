package com.xandy.thread.countdown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Description:����ʱ��
 *
 * @author
 * @version 1.0
 * @date 2018/8/28 21:35 ����
 */
public class CountDownLatchDemo implements Runnable{
    // ����һ����Ҫʮ��ִ�в���ͨ���ȴ��ĵ���ʱ��
    public static CountDownLatch countDownLatch = new CountDownLatch(10);
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println(Thread.currentThread().getId() + "done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo demo = new CountDownLatchDemo();

        for (int i = 0;i < 10;i++) {
            new Thread(demo).start();
        }
        // �ȴ�����ʱ����
        countDownLatch.await();
        System.out.println("������");
    }
}
