package com.xandy.enums;

/**
 * @author liang.xu01
 * @description ö��ʵ�ֲ���ģʽ
 * @date 2020/4/20 15:18
 * @since 1.0
 */
public enum EnumStrategy {
    /**
     * ģ��
     */
    MODEL{
        @Override
        public void show() {
            System.out.println("T̨");
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
