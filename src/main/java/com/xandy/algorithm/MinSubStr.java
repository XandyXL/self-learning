package com.xandy.algorithm;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * leeCode 76. ��С�����Ӵ�
 * ����һ���ַ��� S��һ���ַ��� T�������ַ��� S �����ҳ������� T ������ĸ����С�Ӵ���
 *
 * ʾ����
 *
 * ����: S = "ADOBECODEBANC", T = "ABC"
 * ���: "BANC"
 * ˵����
 *
 * ��� S �в����������Ӵ����򷵻ؿ��ַ��� ""��
 * ��� S �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
 *
 * @author liang.xu01
 * @description ���������㷨 - ��С�����Ӵ�
 * @date 2020/4/22 8:54
 * @since 1.0
 */
public class MinSubStr {

    /**
     * str
     *
     * @param s    �����ַ���
     * @param t Ŀ���ַ���
     * @return ��С�����ַ����Ӵ�
     */
    public static String minWindow(String s, String t) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("�Ƿ����");
        }
        if (t == null || t.isEmpty()) {
            throw new IllegalArgumentException("�Ƿ����");
        }

        Map<Character, Integer> needs = Maps.newHashMap();
        Map<Character, Integer> windows = Maps.newHashMap();

        int left = 0;
        int right = 0;
        int vaild = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        // ת�� {'a':1,'b':1,'c':1}
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            // �����봰�ڵ��ַ�
            char c = s.charAt(right);
            // ���ƴ���
            right++;
            // �������ƴ��ڵ�һϵ�����ݹ�ϵ
            if (needs.containsKey(c)) {
                int v = windows.getOrDefault(c, 0) + 1;
                windows.put(c, v);
                if (v == needs.get(c)) {
                    vaild++;
                }
            }

            // ���Ʋ���,�ж��󴰿��Ƿ�Ҫ����
            while (vaild == needs.size()) {
                // ��С�����Ӵ������ж�
                if (right - left < len ) {
                    start = left;
                    len = right - start;
                }
                // �����ַ������Ƴ����ڵ��ַ�
                char d = s.charAt(left);
                // ���ƴ���
                left++;
                if (needs.containsKey(d)) {
                    if (windows.get(d).equals(needs.get(d))) {
                        vaild--;
                    }
                    // ��ֹwindows���ָ������
                    int v = windows.get(d) - 1;
                    windows.put(d, v < 0 ? 0 : v);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, len + start);
    }

    public static void main(String[] args) {
        String str = "adobeabccodebnaceeacbee";
        String target = "abc";

        String minSubStr = MinSubStr.minWindow(str, target);

        System.out.println(minSubStr);

    }
}
