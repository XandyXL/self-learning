package com.xandy.thread.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Description: CyclicBarrier模拟士兵集体活动
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/8/29 17:54 创建
 */
public class CyclicBarrierDemo {

    /**
     * 士兵线程类
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
                // 等待所有士兵到齐
                cyclicBarrier.await();
                doWork();
                // 等待所有士兵完成任务
                cyclicBarrier.await();
                goSleep();
                // 等待所有士兵就寝
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        /**
         * 模拟工作
         * @throws InterruptedException
         */
        public void doWork() throws InterruptedException {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println(name + "完成任务！");
        }

        /**
         * 模拟睡觉
         * @throws InterruptedException
         */
        public void goSleep() throws InterruptedException {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println(name + "已就寝！");
        }
    }

    /**
     * 集体活动完成标记线程类
     */
    static class BarrierRun implements Runnable {

        @Override
        public void run() {
            System.out.println("一次集体活动结束");
        }
    }

    public static void main(String[] args) {

        int N = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun());

        String name;
        for (int i = 0; i < 10; i++) {
            name = "士兵" + i;
            System.out.println(name + "报道！");
            new Thread(new Soldier(cyclicBarrier, name)).start();
        }

    }

}
