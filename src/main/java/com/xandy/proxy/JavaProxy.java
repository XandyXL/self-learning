package com.xandy.proxy;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/5 15:24 创建
 */
public class JavaProxy {

    public static void main(String[] args) {

        // 代理对象
        TestUserService service = (TestUserService) Proxy.newProxyInstance(JavaProxy.class.getClassLoader(), new Class[]{TestUserService.class},
                new InvocationHandler() {
                    // 代理目标对象
                    TestUserServiceImpl target = new TestUserServiceImpl();
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before");
                        Object result = method.invoke(target, args);
                        System.out.println("after");
                        return result;
                    }
                });
        service.getName("徐良");
    }
}
