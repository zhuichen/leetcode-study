package com.czy.leetcode.dyp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 */
class Solution7 {

    public static void main(String[] args) {
//        int[] array = {2, 3, 2};
//        int[] array = {1, 2, 3, 1};
        int[] array = {200, 3, 140, 20, 10};
        System.out.println(rob(array));
    }

    /**
     * d(i)=max(d(i-1),d(i-2)+nums[i])
     * 围成一圈
     * <p>
     * 头不偷:
     * <p>
     * <p>
     * 尾不偷：
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
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max = 0;
        int pre1 = 0;
        int pre2 = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            max = Math.max(pre2, pre1 + nums[i]);
            pre1 = pre2;
            pre2 = max;
        }
        int max1 = 0;
        int pre3 = 0;
        int pre4 = nums[1];
        for (int i = 2; i < nums.length; i++) {
            max1 = Math.max(pre4, pre3 + nums[i]);
            pre3 = pre4;
            pre4 = max1;
        }
        System.out.println(max1 + " " + max);
        return Math.max(max1, max);

    }

}
