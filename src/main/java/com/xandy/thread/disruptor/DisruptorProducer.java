package com.xandy.thread.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.Sequence;

import java.nio.ByteBuffer;

/**
 * Description:生产者
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/13 21:01 创建
 */
public class DisruptorProducer {

    private RingBuffer<PcData> ringBuffer;

    public DisruptorProducer(RingBuffer<PcData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb){
        long sequence = ringBuffer.next();// 获取下一个序号
        try {
            PcData event = ringBuffer.get(sequence); // 获取entry
            event.setValue(bb.getLong(0)); // 填充数据
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
