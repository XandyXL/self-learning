package com.xandy.algorithm;

import java.math.BigDecimal;

/**
 * @author liang.xu01
 * @description 斐波那契数列
 * PS: 1,1,3,5,8,13...
 * 公式：fib(n) = fib(n - 1) + fib(n - 2) (n > 3,正无穷)，其中 n1 = 1。
 * @date 2020/5/6 14:38
 * @since 1.0
 */
public class FibAlgorithm {

    /**
     * 递归，带有备忘录功能，解决重叠子问题
     * @param n 队列长度
     * @return n位值
     */
    public static BigDecimal fib(int n) {

        // 备忘录
        BigDecimal[] memo = new BigDecimal[n + 1];
        // 初始化
        memo[0] = BigDecimal.ZERO;
        memo[1] = BigDecimal.ONE;
        return helper(memo, n);
    }

    /**
     * 动态规划实现斐波那契队列
     * @param n
     * @return
     */
    public static BigDecimal fibDp(int n) {
        // dp table
        BigDecimal[] memo = new BigDecimal[n + 1];
        memo[0] = BigDecimal.ZERO;
        memo[1] = BigDecimal.ONE;

        for(int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1].add(memo[i - 2]);
        }
        return memo[n];
    }

    /**
     *
     * @param memo 递归
     * @param n
     * @return
     */
    public static BigDecimal helper(BigDecimal[] memo, int n) {
        if (n < 1) {
            return BigDecimal.ZERO;
        } else if (n < 3) {
            return BigDecimal.ONE;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1).add(helper(memo, n - 2));
        return memo[n];
    }




    public static void main(String[] args) {

        int left , right ,ans,x;
        x = 2147395599;
        left = 0;
        right = x;
        ans = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            long squraMid = mid * mid;
            if (squraMid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("ans:" + ans);

        System.out.println("fib:");
        System.out.println(FibAlgorithm.fib(1));
        System.out.println(FibAlgorithm.fib(2));
        System.out.println(FibAlgorithm.fib(3));
        System.out.println(FibAlgorithm.fib(4));
        System.out.println(FibAlgorithm.fib(5));
        System.out.println(FibAlgorithm.fib(6));
        System.out.println(FibAlgorithm.fib(7));
        System.out.println(FibAlgorithm.fib(8));
        System.out.println(FibAlgorithm.fib(9));
        System.out.println(FibAlgorithm.fib(10));
        System.out.println(FibAlgorithm.fib(11));
        System.out.println(FibAlgorithm.fib(13));
        System.out.println(FibAlgorithm.fib(20));
        System.out.println(FibAlgorithm.fib(92));
        System.out.println(FibAlgorithm.fib(95));
        System.out.println("fibDp:");
        System.out.println(FibAlgorithm.fibDp(1));
        System.out.println(FibAlgorithm.fibDp(2));
        System.out.println(FibAlgorithm.fibDp(3));
        System.out.println(FibAlgorithm.fibDp(4));
        System.out.println(FibAlgorithm.fibDp(5));
        System.out.println(FibAlgorithm.fibDp(6));
        System.out.println(FibAlgorithm.fibDp(7));
        System.out.println(FibAlgorithm.fibDp(8));
        System.out.println(FibAlgorithm.fibDp(9));
        System.out.println(FibAlgorithm.fibDp(10));
        System.out.println(FibAlgorithm.fibDp(11));
        System.out.println(FibAlgorithm.fibDp(13));
        System.out.println(FibAlgorithm.fibDp(20));
        System.out.println(FibAlgorithm.fibDp(92));
        System.out.println(FibAlgorithm.fibDp(95));
    }



}
