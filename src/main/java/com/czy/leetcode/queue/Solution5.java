package com.czy.leetcode.queue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 最小区间
 * <p>
 * <p>
 * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * <p>
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出：[20,24]
 * 解释：
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,2,3],[1,2,3],[1,2,3]]
 * 输出：[1,1]
 * 示例 3：
 * <p>
 * 输入：nums = [[10,10],[11,11]]
 * 输出：[10,11]
 * 示例 4：
 * <p>
 * 输入：nums = [[10],[11]]
 * 输出：[10,11]
 * 示例 5：
 * <p>
 * 输入：nums = [[1],[2],[3],[4],[5],[6],[7]]
 * 输出：[1,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums.length == k
 * 1 <= k <= 3500
 * 1 <= nums[i].length <= 50
 * -105 <= nums[i][j] <= 105
 * nums[i] 按非递减顺序排列
 */
class Solution5 {

    public static void main(String[] args) {

    }

    public int[] smallestRange(List<List<Integer>> nums) {

        int l = -1000000000, r = 1000000000, max = -1000000000;

        // 用一个 int[3] 数组来保存 len， height 以及 val
        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator<int[]>) (a, b) -> a[2] - b[2]);

        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{i, 0, nums.get(i).get(0)});
            max = Math.max(max, nums.get(i).get(0));
        }

        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            int minV = item[2], row = item[0], col = item[1];
            if (max - minV < r - l) {
                l = minV;
                r = max;
            }
            if (col == nums.get(row).size() - 1) {
                return new int[]{l, r};
            }
            int next = nums.get(row).get(col + 1);
            pq.offer(new int[]{row, col + 1, next});
            max = Math.max(next, max);
        }

        return new int[]{l, r};
    }


}
