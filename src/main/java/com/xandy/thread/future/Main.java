package com.xandy.thread.future;

/**
 * Description:自定义Future模式入口
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/21 15:04 创建
 */
public class Main {

    public static void main(String[] args) {
        Data data = new Client().request("sssssss");
        System.out.println("请求完毕");
        long start = System.currentTimeMillis();
        // 模拟处理其他业务场景
        System.out.println("看了一场电影");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("吃了一顿海鲜");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据=" + data.getResult() + "耗时：" + (System.currentTimeMillis() - start) / 1000 + "s");
    }
}
