package com.xandy.thread;

/**
 * @author liang.xu01
 * @Description
 * @since 2018/4/12 15:06
 */
public class MyThreadTest01 extends Thread{
    private int count;

    public MyThreadTest01(int count){
        super();
        this.count = count;
    }
    @Override
    public synchronized void run(){
        super.run();
        //此处不能用for循环，会导致一个线程无限执行下去
        count --;
        System.out.println("thread:"+Thread.currentThread().getName()+",count:"+count);
    }

    public static void main(String[] args) {
        MyThreadTest01 myThreadTest01 = new MyThreadTest01(100);

        Thread aa = new Thread(myThreadTest01, "aa");
        Thread bb = new Thread(myThreadTest01, "bb");
        Thread cc = new Thread(myThreadTest01, "cc");
        Thread dd = new Thread(myThreadTest01, "dd");
        aa.start();
        bb.start();
        cc.start();
        dd.start();
    }
}
