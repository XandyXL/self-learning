package com.xandy.guideline;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Random;

/**
 * @author
 * @Description ���￪���淶 ��9������
 * @since 2018/3/13 11:19
 */
public class Other {

    public static final int FOR_MAX_INT = 1000;

    public static void main(String[] args) throws Exception {
        // 5 ���ȡ�������������random.nextInt() �� nextLong
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

        /*�쳣���� finally��������Դ������������йرգ����쳣ҲҪ��try-catch��
            ˵�������JDK7�����ϣ�����ʹ��try-with-resources��ʽ��*/
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