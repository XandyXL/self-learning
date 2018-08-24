package com.xandy.jconsole;

/**
 * @author liang.xu01
 * @Description
 * @since 2018/5/22 15:01
 */
public class SynAddRunable implements Runnable {
    int a, b;

    public SynAddRunable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }

        }
    }

}
