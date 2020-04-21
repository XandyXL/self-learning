package com.xandy.enums;

/**
 * @author liang.xu01
 * @description 枚举实现策略模式
 * @date 2020/4/20 15:18
 * @since 1.0
 */
public enum EnumStrategy {
    /**
     * 模特
     */
    MODEL{
        @Override
        public void show() {
            System.out.println("T台");
        }
    },
    /**
     * cto
     */
    CTO{
        @Override
        public void show () {
            System.out.println("coding");
        }
    };

    public abstract void show ();

    public static void main(String[] args) {
        EnumStrategy.MODEL.show();
    }
}
