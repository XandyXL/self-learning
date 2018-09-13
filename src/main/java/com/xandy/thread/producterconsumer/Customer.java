package com.xandy.thread.producterconsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Description: 生产者-消费者模式  消费者
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/13 20:10 创建
 */
public class Customer implements Runnable {

    private BlockingQueue<PcData> blockingQueue;

    public static final int SLEEPTIME = 1000;

    public Customer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("start custmer id =" + Thread.currentThread().getId());
        PcData data;
        Random r = new Random();
        try {
            while (true) {
                data = blockingQueue.take();
                if (data != null) {
                    int re = data.getValue() * data.getValue();
                    System.out.println("customer data:"
                            + MessageFormat.format("{0}*{1}={2}", data.getValue(), data.getValue(), re));
                }
                Thread.sleep(r.nextInt(SLEEPTIME));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
