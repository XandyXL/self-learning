package com.xandy.datastructure.graph;

/**
 * @author
 * @Description
 * @since 2018/3/6 15:40
 */
public class Queue {

    //队列容量
    public final int SIZE = 20;

    //队列数组
    public int queArray[];

    //队列头下标
    public int front;

    //队列尾下表
    public int rear;

    public Queue() {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    /**
     * 添加队列（队尾）
     *
     * @param v
     */
    public void insert(int v) {
        if (rear == SIZE - 1) {
            rear = -1;
        }
        queArray[++rear] = v;
    }

    /**
     * 移除队列排头
     * @return
     */
    public int remove() {
        int v = queArray[front++];
        if (front == SIZE) {
            front = 0;
        }
        return v;
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return rear + 1 == front || front + SIZE -1 == rear;
    }

}
