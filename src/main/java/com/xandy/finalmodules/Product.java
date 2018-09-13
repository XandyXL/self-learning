package com.xandy.finalmodules;

/**
 * Description:不可变类实例
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/12 15:24 创建
 */
public final class Product {  // 确保无子类

    private final String name; // 私有属性，确保不会被其他对象获取 ，final保证不会被2次赋值

    private final String desc;


    public Product(String name, String desc) {// 创建对象时必须指定属性值
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
