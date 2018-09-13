package com.xandy.thread.producterconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:生产者-消费者模式  生产者
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/13 19:58 创建
 */
public class Producter implements Runnable {

    private BlockingQueue<PcData> blockingQueue;

    private boolean isRunning = true;

    public static AtomicInteger count = new AtomicInteger(100);

    public static final int SLEEPTIME = 1000;

    public Producter(BlockingQueue<PcData> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        if (blockingQueue == null) {
            isRunning = false;
        }
        PcData data;
        Random r = new Random();
        System.out.println("start producter id=" + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PcData(count.getAndIncrement());//构造任务数据
                if (!blockingQueue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("failed to put data:" + data.toString());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
