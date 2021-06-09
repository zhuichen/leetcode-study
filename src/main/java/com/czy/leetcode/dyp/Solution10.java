package com.czy.leetcode.dyp;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 */
class Solution10 {


    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1352));
    }

    /**
     * 2 3 5
     * <p>
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     * <p>
     * todo
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int count = 1;
        for (int i = 2; i < 100000000000L; i++) {
            if (ass(i)) {
                count++;
                if (n == count) {
                    return i;
                }
            }

        }
        throw new RuntimeException("1");
    }

    public static Boolean ass(int num) {
        if (num == 1) {
            return true;
        }
        while (true) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else if (num == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

}
