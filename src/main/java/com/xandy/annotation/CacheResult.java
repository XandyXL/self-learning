package com.xandy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:可以没有任何成员 作为标识
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/25 15:29 创建
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CacheResult {

    /**
     * 成员 无参数方法 类型为原生类型  只有一个成员 只有 value("")
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

        // 1、使用jdk反射获取注解
        Class<AnnoationTest> clazz = AnnoationTest.class;
        Class<CacheResult> annoClazz = CacheResult.class;


        // 获取类注解
        if (clazz.isAnnotationPresent(annoClazz)) {
            CacheResult annotation = clazz.getAnnotation(annoClazz);
            System.out.println(annotation.key());
            System.out.println(annotation.cacheName());
        }

        // 获取方法注解



    }
}

