package com.xandy.genericity;

/**
 * @author liang.xu01
 * @description �����෽��
 * @date 2020/4/20 9:22
 * @since 1.0
 */
public class GenericityMethodTool {

    public <T> void show (T t) {
        System.out.println(t);
    }

    /**
     * Numberû��ʵ��Comparable
     * @param values
     * @param <T>
     * @return
     */
    public static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] != null && min.compareTo(values[i]) > 0) {
                min = values[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        GenericityMethodTool tool = new GenericityMethodTool();
        // ����ʱȷ������
        tool.show(12);
        tool.show("����");

        Integer[] values = new Integer[4];
        values[0] = 1;
        values[1] = 3;
        values[2] = 0;
        values[3] = null;
        Integer min =  GenericityMethodTool.min(values);
        System.out.println(min);
    }
}
