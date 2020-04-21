package com.xandy.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author liang.xu01
 * @description ö��ʵ�ֵ���
 * @date 2020/4/20 14:45
 * @since 1.0
 */
public enum EnumSingleton {
    /**
     * ��������
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
        // ʹ�÷���
        EnumSingleton.getInstance().getMap();
    }

}
