package com.xandy.thread.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: RejectedExecutionHandler 线程池自定义拒绝策略
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/8/30 18:13 创建
 */
public class RejectThreadDemo implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5,
                5,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(10),
                new ThreadFactoryBuilder().setNameFormat("thread-test-%d").build(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + "rejected");
                    }
                });

        // 模拟自定义线程池超负载，执行自定义策略
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            es.submit(new RejectThreadDemo());
            Thread.sleep(10);
        }
    }

}
