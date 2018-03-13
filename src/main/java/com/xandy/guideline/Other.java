package com.xandy.guideline;

import java.util.Random;

/**
 * @author
 * @Description 阿里开发规范 （9）其他
 * @since 2018/3/13 11:19
 */
public class Other {

    public static final int FOR_MAX_INT = 1000;

    public static void main(String[] args) {
        // 5 如果取整数随机数，用random.nextInt() 或 nextLong
        Random random = new Random();
        int randomBetween = 10;
        int[] counts = new int[randomBetween];
        for (int i = 0; i < FOR_MAX_INT; i++) {
            counts[random.nextInt(10)] += 1;
        }
        int j = 0;
        while (j <= randomBetween - 1) {
            System.out.print(j + ":");
            System.out.print(counts[j++] + " ");
        }
    }
}
