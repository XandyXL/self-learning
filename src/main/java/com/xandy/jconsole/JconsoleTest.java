package com.xandy.jconsole;

/**
 * @author liang.xu01
 * @Description
 * @since 2018/4/28 10:59
 */
public class JconsoleTest {


    public static void main(String[] args) {
        // ���� ���������ԭ����Integer.valueOf()���ڼ��ٶ��󴴽��������ڴ濼�ǣ�128~127����ֱ�ӷ���
        // ����Ķ�����200���߳�����ֻ������������ͬ�Ķ���
        for(int i = 0 ; i < 100 ; i++){
            new Thread(new SynAddRunable(1,2)).start();
            new Thread(new SynAddRunable(2,1)).start();
        }
    }


}
