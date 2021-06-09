package com.czy.leetcode.queue;

import java.util.PriorityQueue;

/**
 * 编写一段程序来查找第 n 个超级丑数。
 * <p>
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 说明:
 * <p>
 * 1 是任何给定 primes 的超级丑数。
 * 给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 */
class Solution2 {

    public static void main(String[] args) {
        System.out.println(solve(12));
    }

    public static int solve(int n) {
        int[] ans = new int[n + 5];
        ans[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0, p4 = 0;
        for (int i = 1; i < n; i++) {
            ans[i] = Math.min(ans[p1] * 2, Math.min(ans[p2] * 7, Math.min(ans[p3] * 13, ans[p4] * 19)));
            if (ans[i] == ans[p1] * 2) {
                p1++;
            }
            if (ans[i] == ans[p2] * 7) {
                p2++;
            }
            if (ans[i] == ans[p3] * 13) {
                p3++;
            }
            if (ans[i] == ans[p3] * 19) {
                p4++;
            }
        }
        return ans[n - 1];
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int count = 0;
        long ans = 1;
        queue.add(ans);
        while (count < n) {
            ans = queue.poll();
            while (!queue.isEmpty() && ans == queue.peek()) {
                queue.poll();
            }
            count++;
            for (int i = 0; i < primes.length; i++) {
                queue.offer(ans * primes[i]);
            }
        }
        return (int) ans;
    }

}
