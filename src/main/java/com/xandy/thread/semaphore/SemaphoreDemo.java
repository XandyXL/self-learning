package com.xandy.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Description: 信号量 （允许多个线程同时访问）
 *
 * @author
 * @version 1.0
 * @date 2018/8/28 17:26 创建
 */
public class SemaphoreDemo implements Runnable {

    // 有五个许可数的信号量
    public Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            // 模拟耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + "done");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 每次2秒 都有五个线程访问资源
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0; i < 20; i++) {
            executorService.submit(demo);
        }

    }
}
