package com.xandy.leecode;

import java.util.concurrent.Semaphore;

/**
 * @author liang.xu01
 * @description 1114. �����ӡ
 * �����ṩ��һ���ࣺ
 * <p>
 * public class Foo {
 * ? public void one() { print("one"); }
 * ? public void two() { print("two"); }
 * ? public void three() { print("three"); }
 * }
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/print-in-order
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * ������ͬ���߳̽��Ṳ��һ��?Foo?ʵ����
 * <p>
 * �߳� A ������� one() ����
 * �߳� B �������?two() ����
 * �߳� C ������� three() ����
 * ������޸ĳ�����ȷ�� two() ������ one() ����֮��ִ�У�three() ������ two() ����֮��ִ�С�
 * @date 2020/4/27 14:01
 * @since 1.0
 */
public class Foo {



    public Foo() {

    }

    // countDowLatch
//    private CountDownLatch second = new CountDownLatch(1);
//    private CountDownLatch third = new CountDownLatch(1);
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        second.countDown();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        second.await();
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        third.countDown();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        third.await();
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }

    // �ź��� semaphore

    private Semaphore second = new Semaphore(0);
    private Semaphore third = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

//     CAS����
//    private volatile int flag = 0;
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        flag = 1;
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        while (flag != 1) {
//
//        }
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        flag = 2;
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        while (flag != 2) {
//
//        }
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }


    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();


        Thread t1 = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t3 = new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
