package com.xandy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:����û���κγ�Ա ��Ϊ��ʶ
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/25 15:29 ����
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CacheResult {

    /**
     * ��Ա �޲������� ����Ϊԭ������  ֻ��һ����Ա ֻ�� value("")
     *
     * @return
     */
    String key();

    String cacheName();

    String backCacheName() default "";

    boolean needBloomFilter() default false;

    boolean needLock() default false;


}

@CacheResult(key = "class-key", cacheName = "class-cn")
class AnnoationTest {


    @CacheResult(key = "class-key", cacheName = "class-cn")
    void test() {

    }

    public static void main(String[] args) {

        // 1��ʹ��jdk�����ȡע��
        Class<AnnoationTest> clazz = AnnoationTest.class;
        Class<CacheResult> annoClazz = CacheResult.class;


        // ��ȡ��ע��
        if (clazz.isAnnotationPresent(annoClazz)) {
            CacheResult annotation = clazz.getAnnotation(annoClazz);
            System.out.println(annotation.key());
            System.out.println(annotation.cacheName());
        }

        // ��ȡ����ע��



    }
}

