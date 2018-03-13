package com.xandy.guideline;

/**
 * @author
 * @Description µ¥Ôª²âÊÔassertÊµÀı
 * @since 2018/3/13 14:38
 */
public class AssertTest {

    public static void test1(int a){
        assert a > 0;
    }

    public static void test2(int a){
        assert a == 1 : "fail";
    }

    public static void main(String[] args) {
        test1(4);
        test2(2);
    }
}
