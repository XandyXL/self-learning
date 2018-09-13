package com.xandy.thread.producterconsumer;

/**
 * Description:生产者-消费者模式 生产者发送到内存缓冲区的数据结构
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/13 19:59 创建
 */
public final class PcData {

    //属性值
    private final int value;

    public PcData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PcData{" +
                "value=" + value +
                '}';
    }
}
