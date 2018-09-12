package com.xandy.singleton;

/**
 * Description:懒汉模式，优点 ：使用时创建，缺点：并发调用时效率比饿汉模式低
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/12 10:03 创建
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
        System.out.println("get singleton");
    }

    /**
     * 懒汉模式获取单例
     * @return
     */
    public static synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        System.out.println("test");
        // 不能在StaticSingleton外部使用私有内部类
        StaticSingleton.getInstance();
    }
}
