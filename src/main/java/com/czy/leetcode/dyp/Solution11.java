package com.czy.leetcode.dyp;

import java.util.ArrayList;
import java.util.List;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */
class Solution11 {


    public static void main(String[] args) {

    }

    /**
     * 0,1,2,3,4   每次删除第3个数字
     *
     * <p>
     * d(0)=nums[0]
     * d(1)=nums[1]
     * d(2)=nums[1]
     * <p>
     * i<n d(i)=d(i-1)+3-1
     * <p>
     * <p>
     * <p>
     * <p>
     * d(0)=0;
     * d(1)=nums[0]
     *
     * d(N,M)=(d(N−1,M)+M)%n
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p + 1;
    }


}
