package com.xandy.thread;

/**
 * Description:
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/8/27 18:14 创建
 */
public class PriorityDemo {
    static Object object = new Object();

    static class HighPriority extends Thread{
        static int count = 0;
        @Override
        public void run () {
            synchronized (object){
                while(true){
                    count++;
                    if (count > 10000000) {
                        System.out.println("HighPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    static class LowPriority extends Thread{
        static int count = 0;
        @Override
        public void run () {
            synchronized (object){
                while(true){
                    count++;
                    if (count > 10000000) {
                        System.out.println("LowPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // 高优先级线程，竞争锁时有优先级，但不是所有情况下都能优先执行
        Thread high = new HighPriority();
        high.setPriority(Thread.MAX_PRIORITY);
        Thread low = new LowPriority();
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();

//        int count = 0;
//        while (true) {
//            count ++ ;
//            Thread high = new HighPriority();
//            high.setPriority(Thread.MAX_PRIORITY);
//            Thread low = new LowPriority();
//            low.setPriority(Thread.MIN_PRIORITY);
//            high.start();
//            low.start();
//            if (count > 1000) {
//                break;
//            }
//        }


    }
}
