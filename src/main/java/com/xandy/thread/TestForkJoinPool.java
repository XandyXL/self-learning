package com.xandy.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Description: fork/join���
 *
 * @author
 * @version 1.0
 * @date 2018/8/23 14:28 ����
 */
public class TestForkJoinPool {

    static class MyForkJoinTask extends RecursiveTask<Integer> {
        private int start;
        private int end;

        private static final int MAX = 200;

        public MyForkJoinTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            if (end - start < MAX) {
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                System.out.println("�������1��start:{"+start+"},mid{"+mid+"},end{"+end+"}");
                // ���С����
                MyForkJoinTask task1 = new MyForkJoinTask(start, mid);
                task1.fork();
                MyForkJoinTask task2 = new MyForkJoinTask(mid + 1, end);
                task2.fork();
                return task1.join() + task2.join();
            }
        }
    }


    public static void main(String[] args) throws Exception{
        int start = 1;
        int end = 500;
        // fork/join���
        // ��Ҫ�����̳߳�
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(new MyForkJoinTask(start,end));
        System.out.println(task.get());

        // ����ѭ��
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println(sum);

    }
}
