package com.xandy.thread.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Description: CyclicBarrierģ��ʿ������
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/8/29 17:54 ����
 */
public class CyclicBarrierDemo {

    /**
     * ʿ���߳���
     */
    static class Soldier implements Runnable {
        private CyclicBarrier cyclicBarrier;
        private String name;

        public Soldier(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                // �ȴ�����ʿ������
                cyclicBarrier.await();
                doWork();
                // �ȴ�����ʿ���������
                cyclicBarrier.await();
                goSleep();
                // �ȴ�����ʿ������
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        /**
         * ģ�⹤��
         * @throws InterruptedException
         */
        public void doWork() throws InterruptedException {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println(name + "�������");
        }

        /**
         * ģ��˯��
         * @throws InterruptedException
         */
        public void goSleep() throws InterruptedException {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println(name + "�Ѿ��ޣ�");
        }
    }

    /**
     * ������ɱ���߳���
     */
    static class BarrierRun implements Runnable {

        @Override
        public void run() {
            System.out.println("һ�μ�������");
        }
    }

    public static void main(String[] args) {

        int N = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun());

        String name;
        for (int i = 0; i < 10; i++) {
            name = "ʿ��" + i;
            System.out.println(name + "������");
            new Thread(new Soldier(cyclicBarrier, name)).start();
        }

    }

}
