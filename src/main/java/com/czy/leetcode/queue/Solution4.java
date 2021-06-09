package com.czy.leetcode.queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。
 * <p>
 * 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,3,11],[2,4,6]], k = 5
 * 输出：7
 * 解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
 * [1,2], [1,4], [3,2], [3,4], [1,6]。其中第 5 个的和是 7 。
 * 示例 2：
 * <p>
 * 输入：mat = [[1,3,11],[2,4,6]], k = 9
 * 输出：17
 * 示例 3：
 * <p>
 * 输入：mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
 * 输出：9
 * 解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
 * [1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]。其中第 7 个的和是 9 。
 * 示例 4：
 * <p>
 * 输入：mat = [[1,1,10],[2,2,9]], k = 7
 * 输出：12
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat.length[i]
 * 1 <= m, n <= 40
 * 1 <= k <= min(200, n ^ m)
 * 1 <= mat[i][j] <= 5000
 * mat[i] 是一个非递减数组
 */
class Solution4 {


    public static void main(String[] args) {
        int[][] mat = {{1, 3, 11}, {2, 4, 6}};
        System.out.println(kthSmallest(mat, 5));
    }


    public static int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<Pair<Integer, int[]>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        int[] sum = new int[m];
        int total = 0;
        for (int i = 0; i < m; i++) {
            total += mat[i][0];
        }
        Pair<Integer, int[]> pair = new Pair(total, sum);
        pq.offer(pair);
        Set<String> seen = new HashSet<>();

        // 小顶堆 执行k次 把前面k小的数组移除 之后栈顶便是我们所求之结果
        while (--k > 0) {
            Pair<Integer, int[]> cur = pq.poll();
            // 行号
            for (int i = 0; i < m; i++) {
                if (cur.getValue()[i] < n - 1) {
                    int[] arr = Arrays.copyOf(cur.getValue(), m);
                    // 列号
                    arr[i]++;
                    if (!seen.contains(Arrays.toString(arr))) {
                        seen.add(Arrays.toString(arr));
                        int next = cur.getKey() - mat[i][cur.getValue()[i]] + mat[i][arr[i]];
                        pq.offer(new Pair(next, arr));
                    }
                }
            }
        }
        return pq.peek().getKey();
    }


}
