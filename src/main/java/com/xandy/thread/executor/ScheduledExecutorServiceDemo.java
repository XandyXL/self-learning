package com.xandy.thread.executor;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/8/29 20:24 创建
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {


        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        // 周期执行线程
        // 当周期执行时间 period > 线程执行时间 时，执行周期为 period
        // 当周期执行时间 period < 线程执行时间 时，下一个任务就会立即执行
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getId() + "start time:" + System.currentTimeMillis() / 1000);
                    // 模拟线程执行时间
                    long randomLong = new Random().nextInt(10)*1000L;
                    System.out.println("模拟线程执行时间"+randomLong);
                    Thread.sleep(randomLong);
                    System.out.println(Thread.currentThread().getId() + "end time:" + System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5, TimeUnit.SECONDS);

        // 周期执行线程 观察到结果为 下一个线程的执行时间为  上一个线程结束时间+2秒 （lastEndTime + delayTime）
//        ses.scheduleWithFixedDelay(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println(Thread.currentThread().getId() + "start time:" + System.currentTimeMillis() / 1000);
//                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread().getId() + "end time:" + System.currentTimeMillis() / 1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, 0, 2, TimeUnit.SECONDS);
    }
}
