package com.xandy.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Description: �ź��� ���������߳�ͬʱ���ʣ�
 *
 * @author
 * @version 1.0
 * @date 2018/8/28 17:26 ����
 */
public class SemaphoreDemo implements Runnable {

    // �������������ź���
    public Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            // ģ���ʱ����
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + "done");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // ÿ��2�� ��������̷߳�����Դ
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0; i < 20; i++) {
            executorService.submit(demo);
        }

    }
}
