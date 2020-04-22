package com.xandy.algorithm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        Map<Character, Integer> needs = new HashMap<>(16);
        Map<Character, Integer> windows = new HashMap<>(16);

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

    /**
     *
     * description:
     * 567. 字符串的排列
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 示例1:
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     *
     *
     * 示例2:
     *
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     *
     *
     * 注意：
     *
     * 输入的字符串只包含小写字母
     * 两个字符串的长度都在 [1, 10,000] 之间
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

        // 转成 {'a':1,'b':1,'c':1}
        for (char c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            // 将移入窗口的字符
            char c = s2.charAt(right);
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
            while (right - left >= s1.length()) {
                // 最小覆盖子串长度判断
                if (vaild == needs.size() ) {
                    return true;
                }
                // 左移字符，即移出窗口的字符
                char d = s2.charAt(left);
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
        return false;
    }

    /**
     *
     * description:
     * 438. 找到字符串中所有字母异位词
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     *
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     *
     * 说明：
     *
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     * 示例 1:
     *
     * 输入:
     * s: "cbaebabacd" p: "abc"
     *
     * 输出:
     * [0, 6]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     *  示例 2:
     *
     * 输入:
     * s: "abab" p: "ab"
     *
     * 输出:
     * [0, 1, 2]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
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

        // 转成 {'a':1,'b':1,'c':1}
        for (char c : p.toCharArray()) {
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
            while (right - left >= p.length()) {
                // 最小覆盖子串长度判断
                if (vaild == needs.size() ) {
                    result.add(left);
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
        return result;
    }

    public static void main(String[] args) {
        String str = "adobeabccodebnaceeacbee";
        String target = "abc";

        String minSubStr = MinSubStr.minWindow(str, target);

        System.out.println(minSubStr);

    }
}
