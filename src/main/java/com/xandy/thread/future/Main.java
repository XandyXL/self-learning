package com.xandy.thread.future;

/**
 * Description:�Զ���Futureģʽ���
 *
 * @author liang.xu01
 * @version 1.0
 * @date 2018/9/21 15:04 ����
 */
public class Main {

    public static void main(String[] args) {
        Data data = new Client().request("sssssss");
        System.out.println("�������");
        long start = System.currentTimeMillis();
        // ģ�⴦������ҵ�񳡾�
        System.out.println("����һ����Ӱ");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("����һ�ٺ���");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("����=" + data.getResult() + "��ʱ��" + (System.currentTimeMillis() - start) / 1000 + "s");
    }
}
