package com.xandy.algorithm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        Map<Character, Integer> needs = new HashMap<>(16);
        Map<Character, Integer> windows = new HashMap<>(16);

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

    /**
     *
     * description:
     * 567. �ַ���������
     * ���������ַ��� s1 �� s2��дһ���������ж� s2 �Ƿ���� s1 �����С�
     *
     * ���仰˵����һ���ַ���������֮һ�ǵڶ����ַ������Ӵ���
     *
     * ʾ��1:
     *
     * ����: s1 = "ab" s2 = "eidbaooo"
     * ���: True
     * ����: s2 ���� s1 ������֮һ ("ba").
     *
     *
     * ʾ��2:
     *
     * ����: s1= "ab" s2 = "eidboaoo"
     * ���: False
     *
     *
     * ע�⣺
     *
     * ������ַ���ֻ����Сд��ĸ
     * �����ַ����ĳ��ȶ��� [1, 10,000] ֮��
     * @author liang.xu01
     * @date 2020/4/22 16:53
     * @param
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> needs = new HashMap<>(16);
        Map<Character, Integer> windows = new HashMap<>(16);

        int left = 0;
        int right = 0;
        int vaild = 0;

        // ת�� {'a':1,'b':1,'c':1}
        for (char c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            // �����봰�ڵ��ַ�
            char c = s2.charAt(right);
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
            while (right - left >= s1.length()) {
                // ��С�����Ӵ������ж�
                if (vaild == needs.size() ) {
                    return true;
                }
                // �����ַ������Ƴ����ڵ��ַ�
                char d = s2.charAt(left);
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
        return false;
    }

    /**
     *
     * description:
     * 438. �ҵ��ַ�����������ĸ��λ��
     * ����һ���ַ��� s ��һ���ǿ��ַ��� p���ҵ� s �������� p ����ĸ��λ�ʵ��Ӵ���������Щ�Ӵ�����ʼ������
     *
     * �ַ���ֻ����СдӢ����ĸ�������ַ��� s �� p �ĳ��ȶ������� 20100��
     *
     * ˵����
     *
     * ��ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
     * �����Ǵ������˳��
     * ʾ�� 1:
     *
     * ����:
     * s: "cbaebabacd" p: "abc"
     *
     * ���:
     * [0, 6]
     *
     * ����:
     * ��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����ĸ��λ�ʡ�
     * ��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����ĸ��λ�ʡ�
     *  ʾ�� 2:
     *
     * ����:
     * s: "abab" p: "ab"
     *
     * ���:
     * [0, 1, 2]
     *
     * ����:
     * ��ʼ�������� 0 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
     * ��ʼ�������� 1 ���Ӵ��� "ba", ���� "ab" ����ĸ��λ�ʡ�
     * ��ʼ�������� 2 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
     * @author liang.xu01
     * @date 2020/4/22 16:57
     * @param
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>(16);
        Map<Character, Integer> windows = new HashMap<>(16);

        int left = 0;
        int right = 0;
        int vaild = 0;
        List<Integer> result = new ArrayList<>();

        // ת�� {'a':1,'b':1,'c':1}
        for (char c : p.toCharArray()) {
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
            while (right - left >= p.length()) {
                // ��С�����Ӵ������ж�
                if (vaild == needs.size() ) {
                    result.add(left);
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
        return result;
    }

    public static void main(String[] args) {
        String str = "adobeabccodebnaceeacbee";
        String target = "abc";

        String minSubStr = MinSubStr.minWindow(str, target);

        System.out.println(minSubStr);

    }
}
