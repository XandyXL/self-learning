package com.xandy.guideline;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Random;

/**
 * @author
 * @Description 阿里开发规范 （9）其他
 * @since 2018/3/13 11:19
 */
public class Other {

    public static final int FOR_MAX_INT = 1000;

    public static void main(String[] args) throws Exception {
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

        /*异常处理 finally块必须对资源对象、流对象进行关闭，有异常也要做try-catch。
            说明：如果JDK7及以上，可以使用try-with-resources方式。*/
        try (FileInputStream inputStream = new FileInputStream("D://book.log");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            //DO SOMETHING
            int data = bufferedInputStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = bufferedInputStream.read();
            }
        }
    }
}
