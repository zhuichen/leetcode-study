package com.czy.leetcode.dyp;

/**
 * todo
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 */
class Solution13 {

    public static void main(String[] args) {
//        int[] array={1,3,5,4,7};
//        int[] array={2,2,2,2,2};
        // 3
        int[] array = {1,2,4,3,5,4,7,2};
        System.out.println(findNumberOfLIS(array));
    }


    /**
     * [2,2,2,2,2]
     * 5
     * [1,3,5,4,7]
     * <p>
     * [1, 3, 4, 7]、[1, 3, 5, 7]
     * <p>
     * d(0)=1
     * d(1)=1
     * d(2)=1
     * d(3)=2
     * d(4)=2
     * <p>
     * <p>
     * nums[i]>max(0..nums[i-1]):d(n)=d(n-1)
     * nums[i]=max(0..nums[i-1]):d(n)=d(n-1)+1
     * nums[i]<max(0..nums[i-1])&&nums[i]>nums[i-2] : d(n)=d(n-1)+1
     * TODO 好难
     * @param nums
     * @return
     */
    public static int findNumberOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int preMax = nums[0];
        int res = 0;
        int dp1 = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > preMax) {
                res = dp1;
            } else {
                res = dp1 + 1;
            }
            dp1 = res;
            preMax = Math.max(preMax, nums[i]);
        }
        return res;
    }


}
