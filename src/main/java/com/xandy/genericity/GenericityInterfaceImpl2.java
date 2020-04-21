package com.xandy.genericity;

/**
 * @author liang.xu01
 * @description 泛型派生子类不明确泛型类型参数变量
 * @date 2020/4/20 9:34
 * @since 1.0
 */
public class GenericityInterfaceImpl2<T> implements GenericityInterface<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
