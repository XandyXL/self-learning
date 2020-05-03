package com.xandy.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liang.xu01
 * @description 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @date 2020/5/3 9:08
 * @since 1.0
 */
public class LeeCode3 {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> needs = new HashMap<>(s.length());
        char[] strArr = s.toCharArray();
        int left = 0;
        int right = 0;
        // 无重复字符长度
        int valid;
        // 最大长度
        int lengthOfLong = 0;
        // 窗口右移
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
            // 窗口左移
            while (needs.get(temp) > 1 && left < right) {
                char temp1 = strArr[left++];
                // 大于1 就减一，否则移除字符
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
