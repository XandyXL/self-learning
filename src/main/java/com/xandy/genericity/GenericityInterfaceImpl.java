package com.xandy.genericity;

/**
 * @author liang.xu01
 * @description 派生子类确定参数类型
 * @date 2020/4/20 9:31
 * @since 1.0
 */
public class GenericityInterfaceImpl implements GenericityInterface<String>{

    @Override
    public void show(String o) {
        System.out.println(o);
    }
}
