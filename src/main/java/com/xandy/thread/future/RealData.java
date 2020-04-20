package com.xandy.thread.future;

/**
 * Description:真实数据
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/21 14:38 创建
 */
public class RealData implements Data{

    /**
     * 最终结果
     */
    private String result;

    public RealData(String result) {
        // 模拟真实数据构造面
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.result = result;
    }

    @Override
    public String getResult() {
        return result;
    }
}
