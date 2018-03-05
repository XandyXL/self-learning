package com.xandy.datastructure.graph;

/**
 * @author liang.xu01@ucarinc.com
 * @Description
 * @since 2018/3/5 17:54
 */
public class Stack {

    public final int MAX_INDEX = 20;

    public int st[];

    public int top;

    public Stack() {
        st = new int[MAX_INDEX];
        top = -1;
    }

    //获取最上面的值
    public int peek() {
        return st[top];
    }

    //入栈
    public void push(int v) {
        st[++top] = v;
    }

    //出栈
    public int pop() {
        return st[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
