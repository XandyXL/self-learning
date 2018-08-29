package com.xandy.thread.countdown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Description:倒计时器
 *
 * @author
 * @version 1.0
 * @date 2018/8/28 21:35 创建
 */
public class CountDownLatchDemo implements Runnable{
    // 创建一个需要十次执行才能通过等待的倒计时器
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
        // 等待倒计时结束
        countDownLatch.await();
        System.out.println("检测完成");
    }
}
