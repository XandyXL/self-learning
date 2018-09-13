package com.xandy.thread.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * Description:消费者
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/13 21:09 创建
 */
public class DisruptorConsumer implements WorkHandler<PcData> {

    @Override
    public void onEvent(PcData event) throws Exception {
        System.out.println(Thread.currentThread().getId() + "event-->" + event.getValue());
    }
}
