package com.xandy.thread.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Description: 消息工厂
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/13 20:59 创建
 */
public class PcDataFactory implements EventFactory<PcData> {
    @Override
    public PcData newInstance() {
        return new PcData();
    }
}
