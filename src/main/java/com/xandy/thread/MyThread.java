package com.xandy.thread;

import java.util.Random;

/**
 * @author liang.xu01
 * @Description
 * @since 2018/4/12 10:22
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        int randomInt = 100;
        try {
            for (int i = 0; i < 10; i++) {
                randomInt = random.nextInt(1001);
                Thread.sleep(randomInt);
                System.out.println("run:" + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 多个线程同时启动，执行顺序随机；start() 调用顺序不等同于线程执行的顺序
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();

        Random random = new Random();
        int randomInt = 100;
        try {
            for (int i = 0; i < 10; i++) {
                randomInt = random.nextInt(1001);
                Thread.sleep(randomInt);
                System.out.println("main:" + Thread.currentThread().getName() + ",count:" + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
