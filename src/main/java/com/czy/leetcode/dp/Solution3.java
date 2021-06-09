package com.czy.leetcode.dp;

/**
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 4
 */
class Solution3 {


    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.climbStairs(5));
    }

    /***
     * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * d(1)=1
     * d(2)=1n+2n=2
     * d(n)=d(n-1)+d(n-2)
     * d(4)=d(3)+d(2)=5
     * d(5)=d(4)+d(3)=5+3=8
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int cur = 0;
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 3; i <= n; i++) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;

    }


}
