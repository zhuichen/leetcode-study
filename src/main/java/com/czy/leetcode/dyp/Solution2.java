package com.czy.leetcode.dyp;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 */
class Solution2 {

    public static void main(String[] args) {

        System.out.println(numWays(7));
    }


    public static int numWays(int n) {

        int n1 = 0;
        int n2 = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = (n2 + n1) % 1000000007;
            n1 = n2;
            n2 = sum;
        }

        return n2;

    }


}
