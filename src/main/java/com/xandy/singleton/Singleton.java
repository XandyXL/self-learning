package com.xandy.singleton;

/**
 * Description:饿汉单例模式 优点：并发调用下线程安全，缺点：这种模式 只要类初始化一次，instance都会被创建，即使没有被使用也是如此
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/12 9:55 创建
 */
public class Singleton {

    private static final Singleton SINGLETON = new Singleton();

    private Singleton() {
        System.out.println("get singleton");
    }

    /**
     * 获取单例
     * @return
     */
    public static Singleton getInstance() {
        return SINGLETON;
    }

    public static void main(String[] args) {
        System.out.println("test");
    }

}
