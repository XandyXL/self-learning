package com.xandy.genericity;

/**
 * @author liang.xu01
 * @description ��������ȷ����������
 * @date 2020/4/20 9:31
 * @since 1.0
 */
public class GenericityInterfaceImpl implements GenericityInterface<String>{

    @Override
    public void show(String o) {
        System.out.println(o);
    }
}
