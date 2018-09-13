package com.xandy.thread.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/13 21:11 创建
 */
public class DisruptorMain {

    public static void main(String[] args) throws InterruptedException {

        // 创建线程池
        ExecutorService service = Executors.newCachedThreadPool();
        // ring buffer 大小  2的次方数
        int bufferSize = 1024;
        // 事件工厂

        EventFactory<PcData> factory = new PcDataFactory();
        Disruptor<PcData> disruptor = new Disruptor<PcData>(factory,
                bufferSize,
                service,
                ProducerType.MULTI,
                new BlockingWaitStrategy());

        disruptor.handleEventsWithWorkerPool(
                new DisruptorConsumer(),
                new DisruptorConsumer(),
                new DisruptorConsumer(),
                new DisruptorConsumer());

        disruptor.start();

        RingBuffer<PcData> ringBuffer = disruptor.getRingBuffer();
        DisruptorProducer producer = new DisruptorProducer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            producer.pushData(bb.putLong(0,l));
            Thread.sleep(100);
            System.out.println("add data " + l);
        }
    }


}
