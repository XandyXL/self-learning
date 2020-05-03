package com.xandy.leecode;

import java.util.concurrent.Semaphore;

/**
 * @author liang.xu01
 * @description 1114. 按序打印
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 * ? public void one() { print("one"); }
 * ? public void two() { print("two"); }
 * ? public void three() { print("three"); }
 * }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 三个不同的线程将会共用一个?Foo?实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用?two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
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

    // 信号量 semaphore

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

//     CAS自旋
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
