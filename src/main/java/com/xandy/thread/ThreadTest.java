package com.xandy.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @Description
 * @since 2018/3/28 10:53
 */
public class ThreadTest {

    public static void main(String[] args) {
        //1.请选出下段代码正确的输出值 ( )
        int num = 0;
        for (int i = 0; i < 4; i++) {
            if (i == 1) {
                continue;
            }
            if (i == 2) {
                break;
            }
            num += i;
        }
        System.out.println(num);

        //2.当输入参数i=2时，请选出下段代码正确的返回值 ( )
        System.out.println(getValue(2));

        //3.请选出下段代码正确的输出 ( )
        List<Integer> list = new ArrayList(Arrays.asList(2, 3, 4));
        changeA(list);
        changeB(list);
        changeC(list);
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
        }
    }

    static void changeA(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, i + 1);
        }
    }

    static void changeB(List<Integer> list) {
        list.remove(1);
    }

    static void changeC(List<Integer> list) {
        list = null;
    }

    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            default:
                result = result + i * (i++);
        }
        return result;
    }

    /**
     * 5.给定一个数组, 其有以下特点：
     * 长度为奇数个
     * 无序正整数
     * 对任一个元素，存在其克隆元素，除了某一个元素
     * 例子： int[] array = {1, 4, 2, 9, 2, 1, 9}; 对1、2、9均存在克隆元素，除了4。
     * 请找出这单一的元素(本例为4)是什么？要求方法的时间复杂度越低越好。
     *
     * @param allCoupleExceptOneInArray
     * @return
     */
    public static int getSingleElement(int[] allCoupleExceptOneInArray) {
        if (allCoupleExceptOneInArray == null || allCoupleExceptOneInArray.length == 0
                || allCoupleExceptOneInArray.length % 2 == 1) {
            throw new RuntimeException("请输入正确数组");
        }

        /*int[] tempArray = new int[(allCoupleExceptOneInArray.length + 1) / 2];
        int value = 0;
        for(int i : allCoupleExceptOneInArray){
              for(){

              }
        }*/


        return 0;
    }
}


class A {
    static {
        System.out.println("static A");
    }

    public A() {
        System.out.println("construct A");
    }

    public A(String name) {
        System.out.println("construct A with param");
        this.name = name;
    }

    protected String name;

    public String getName() {
        return name;
    }
}

class B extends A {
    static {
        System.out.println("static B");
    }

    public B() {
        super();
        System.out.println("construct B");
    }

    public B(String name) {
        System.out.println("construct B with param");
        this.name = name;
    }

    public static void main(String[] args) {
        //4.请指出下题的完整输出：
        A a = new B();
        a = new B("Hello World!");
        a = null;
    }
}


