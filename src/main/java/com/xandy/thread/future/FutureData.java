package com.xandy.thread.future;

/**
 * Description:虚拟数据，对RealData的包装
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/21 14:40 创建
 */
public class FutureData implements Data {
    /**
     * 真实数据
     */
    private RealData realData;

    /**
     * 真实数据是否准备完毕
     */
    private boolean isReady = false;

    @Override
    public synchronized String getResult() {
        while (!isReady) {
            try {
                // realData未注入，一直等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getResult();
    }

    /**
     * 设置真实数据
     */
    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        this.isReady = true;
        // realData注入完成，通知getResult();
        notifyAll();
    }
}
