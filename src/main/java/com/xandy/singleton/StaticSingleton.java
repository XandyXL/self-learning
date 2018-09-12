package com.xandy.singleton;

/**
 * Description:兼具两种模式优点，高并发下不影响性能，并且单例在使用时才被创建
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/12 10:21 创建
 */
public class StaticSingleton {

    private StaticSingleton() {
        System.out.println("create staticSingleton");
    }

    /**
     * 单例持有者，私有内部类，防止外部类直接访问
     */
    private static class StaticSingletonHolder{
        private static final StaticSingleton staticSingleton = new StaticSingleton();
    }

    /**
     * 获取单例
     * @return
     */
    public static StaticSingleton getInstance() {
        return StaticSingletonHolder.staticSingleton;
    }

    public static void main(String[] args) {
        System.out.println("test");
        StaticSingleton.getInstance();

    }
}
