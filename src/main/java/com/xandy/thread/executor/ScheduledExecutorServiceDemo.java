package com.xandy.thread.executor;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/8/29 20:24 ����
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {


        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        // ����ִ���߳�
        // ������ִ��ʱ�� period > �߳�ִ��ʱ�� ʱ��ִ������Ϊ period
        // ������ִ��ʱ�� period < �߳�ִ��ʱ�� ʱ����һ������ͻ�����ִ��
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getId() + "start time:" + System.currentTimeMillis() / 1000);
                    // ģ���߳�ִ��ʱ��
                    long randomLong = new Random().nextInt(10)*1000L;
                    System.out.println("ģ���߳�ִ��ʱ��"+randomLong);
                    Thread.sleep(randomLong);
                    System.out.println(Thread.currentThread().getId() + "end time:" + System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5, TimeUnit.SECONDS);

        // ����ִ���߳� �۲쵽���Ϊ ��һ���̵߳�ִ��ʱ��Ϊ  ��һ���߳̽���ʱ��+2�� ��lastEndTime + delayTime��
//        ses.scheduleWithFixedDelay(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println(Thread.currentThread().getId() + "start time:" + System.currentTimeMillis() / 1000);
//                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread().getId() + "end time:" + System.currentTimeMillis() / 1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, 0, 2, TimeUnit.SECONDS);
    }
}
