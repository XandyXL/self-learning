package com.xandy.algorithm;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * leeCode 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * @author liang.xu01
 * @description 滑动窗口算法 - 最小覆盖子串
 * @date 2020/4/22 8:54
 * @since 1.0
 */
public class MinSubStr {

    /**
     * str
     *
     * @param s    窗口字符串
     * @param t 目标字符串
     * @return 最小覆盖字符串子串
     */
    public static String minWindow(String s, String t) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("非法入参");
        }
        if (t == null || t.isEmpty()) {
            throw new IllegalArgumentException("非法入参");
        }

        Map<Character, Integer> needs = Maps.newHashMap();
        Map<Character, Integer> windows = Maps.newHashMap();

        int left = 0;
        int right = 0;
        int vaild = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        // 转成 {'a':1,'b':1,'c':1}
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            // 将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行右移窗口的一系列数据梗系
            if (needs.containsKey(c)) {
                int v = windows.getOrDefault(c, 0) + 1;
                windows.put(c, v);
                if (v == needs.get(c)) {
                    vaild++;
                }
            }

            // 左移操作,判断左窗口是否要收缩
            while (vaild == needs.size()) {
                // 最小覆盖子串长度判断
                if (right - left < len ) {
                    start = left;
                    len = right - start;
                }
                // 左移字符，即移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                if (needs.containsKey(d)) {
                    if (windows.get(d).equals(needs.get(d))) {
                        vaild--;
                    }
                    // 防止windows出现负数情况
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
