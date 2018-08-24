package com.xandy.jconsole;

/**
 * @author liang.xu01
 * @Description
 * @since 2018/4/28 10:59
 */
public class JconsoleTest {


    public static void main(String[] args) {
        // 死锁 造成死锁的原因是Integer.valueOf()基于减少对象创建次数和内存考虑，128~127将会直接返回
        // 缓存的对象，这200个线程请求只返回了两个不同的对象。
        for(int i = 0 ; i < 100 ; i++){
            new Thread(new SynAddRunable(1,2)).start();
            new Thread(new SynAddRunable(2,1)).start();
        }
    }


}
