package com.czy.leetcode.dyp;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 10^5
 * <p>
 *  
 * <p>
 * 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
class Solution12 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }


    /**
     * [7,1,5,3,6,4]
     * <p>
     * d(0)=0
     * d(1)=nums[1]-nums[0]>0?nums[1]-nums[0]:0
     * d(2)=max(nums[3]-mus[1],nums[3]-nums[2])
     * <p>
     * d(0)=0
     * d(1)=0
     * d(2)=4
     * d(3)=4
     * d(5)=5
     * d(6)=5
     * <p>
     * d(0)=0
     * d(n)=max(nums[i]-min(0..nums(n-1)),d(n-1))
     * <p>
     * d(1)=max(1-7,0)=0
     * d(2)=max(5-1,d(2-1))=4
     * d(3)=max(3-1,d(3-1))=4
     * d(4)=max(6-1,d(3))=5
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int preMin = prices[0];
        int d1 = 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(prices[i] - preMin, d1);
            d1 = res;
            preMin = Math.min(preMin, prices[i]);
        }
        return res;
    }


}
