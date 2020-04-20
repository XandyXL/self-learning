package com.xandy.genericity;

/**
 * @author liang.xu01
 * @description
 * @date 2020/4/17 17:19
 * @since 1.0
 */
public class GenericityTool<T> {

    private T obj;

    public T getObj () {
        return obj;
    }

    public void setObj (T t) {
        this.obj = t;
    }

    public static void main(String[] args) {
        GenericityTool<String> genericityTool = new GenericityTool<>();
        genericityTool.setObj("ÄÚÈÝ²»´í");
        System.out.println(genericityTool.getObj());
    }
}
