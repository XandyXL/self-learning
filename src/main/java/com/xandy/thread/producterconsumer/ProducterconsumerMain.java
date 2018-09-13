package com.xandy.thread.producterconsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description:
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/13 20:27 创建
 */
public class ProducterconsumerMain {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();//建立线程池

        // 建立缓存区
        BlockingQueue<PcData> queue = new LinkedBlockingQueue<>(10);

        for (int i = 0; i < 3; i++) {
            // 创建生产者并生产
            service.execute(new Producter(queue));
            // 创建消费者并消费
            service.execute(new Customer(queue));
        }

    }
}
