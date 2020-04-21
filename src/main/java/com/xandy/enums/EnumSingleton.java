package com.xandy.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author liang.xu01
 * @description 枚举实现单例
 * @date 2020/4/20 14:45
 * @since 1.0
 */
public enum EnumSingleton {
    /**
     * 单例工厂
     */
    INSTANCE;

    /**
     *
     */
    EnumSingleton() {

    }

    private Map<String, String> map = Maps.newHashMap();

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public static void main(String[] args) {
        // 使用方法
        EnumSingleton.getInstance().getMap();
    }

}
