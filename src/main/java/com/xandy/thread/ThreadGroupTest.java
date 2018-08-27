package com.xandy.thread;

/**
 * Description:
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/8/27 17:40 创建
 */
public class ThreadGroupTest extends Thread{

    private Object object;

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("threadGroup");
        Thread t1 = new Thread(group,new ThreadGroupTest(),"t1");
        Thread t2 = new Thread(group,new ThreadGroupTest(),"t2");
        t1.start();
        t2.start();
        Thread.sleep(2000);
        System.out.println(group.activeCount());
        System.out.println(t1.isAlive());

    }

    @Override
    public void run(){
      //  synchronized (object){
            System.out.println("测试线程组");
       // }
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
