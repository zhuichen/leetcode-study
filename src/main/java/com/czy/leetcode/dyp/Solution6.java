package com.czy.leetcode.dyp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
class Solution6 {

    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 1};
        // 12
        int[] array = {2, 7, 9, 3, 1};
//        int[] array = {2, 1, 1, 2};
        System.out.println(rob(array));
    }

    /**
     * 不偷：d(i)=d(i-1)
     * 偷: d(i)=nums[i]+d(i-2)
     * <p>
     * d(i)=max(d(i-1),nums[i]+d(i-2))
     *
     * <p>
     * d(0)=0 0个房子
     * d(1)=1 1个房子
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max = 0;
        int pre1 = 0;
        int pre2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(pre2, pre1 + nums[i]);
            System.out.println(max);
            pre1 = pre2;
            pre2 = max;
        }
        return max;
    }

    /**
     * 滚动数组
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

}
