package com.xandy.thread.future;

/**
 * Description:
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/21 14:45 创建
 */
public class Client {


    /**
     * 立即返回futureData
     * @param param
     * @return
     */
    public Data request(final String param){
        final FutureData future = new FutureData();
        // 单独的线程取构建真实数据
        new Thread(){
            @Override
            public void run() {
                future.setRealData(new RealData(param));
            }
        }.start();
        return future;
    }

}
