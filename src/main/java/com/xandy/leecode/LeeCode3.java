package com.xandy.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liang.xu01
 * @description 3. ���ظ��ַ�����Ӵ�
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * @date 2020/5/3 9:08
 * @since 1.0
 */
public class LeeCode3 {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> needs = new HashMap<>(s.length());
        char[] strArr = s.toCharArray();
        int left = 0;
        int right = 0;
        // ���ظ��ַ�����
        int valid;
        // ��󳤶�
        int lengthOfLong = 0;
        // ��������
        while (right < strArr.length) {
            char temp = strArr[right];
            right++;
            if (needs.containsKey(temp)) {
                needs.put(temp, needs.get(temp) + 1);
            } else {
                needs.put(temp, 1);
                valid = right - left;
                lengthOfLong = lengthOfLong < valid ? valid : lengthOfLong;
            }
            // ��������
            while (needs.get(temp) > 1 && left < right) {
                char temp1 = strArr[left++];
                // ����1 �ͼ�һ�������Ƴ��ַ�
                if (needs.get(temp1) > 1) {
                    needs.put(temp1, needs.get(temp1) - 1);
                } else {
                    needs.remove(temp1);
                }
            }
        }
        return lengthOfLong;
    }

    public static void main(String[] args) {

        System.out.println(LeeCode3.lengthOfLongestSubstring("tmmzuxt"));
    }
}
