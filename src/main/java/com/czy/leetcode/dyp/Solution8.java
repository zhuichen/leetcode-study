package com.czy.leetcode.dyp;


/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= num < 231
 */
class Solution8 {

    public static void main(String[] args) {
        System.out.println(translateNum(506));
    }

    /**
     * 12258
     * <p>
     * 1 1
     * 12 1,2# 12
     * 122 1,2,2#  12,2# 1,22
     * 1225 1,2,2,5# 12,2,5# 12,25#1,2,25
     * <p>
     * 0-26 d(i)=d(i-2)+d(i-1)
     * <p>
     * >26  d(i)=d(i-1)
     * <p>
     *
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        String[] numArray = String.valueOf(num).split("");
        if (numArray.length == 1) {
            return 1;
        }
        int pre1 = 0;
        int pre2 = 1;
        int res = 0;
        for (int i = 0; i < numArray.length; i++) {
            String s = i > 0 ? numArray[i - 1] + numArray[i] : numArray[i];
            int flag = Integer.parseInt(s);
            if (flag >= 10 && flag < 26) {
                res = pre1 + pre2;
            } else {
                res = pre2;
            }
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }

    /**
     * leetcode
     *
     * @param num
     * @return
     */
    public int translateNum2(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int x = 1;
        int y = 1;
        for (int i = 2; i <= len; i++) {
            String sub = numStr.substring(i - 2, i);
            int z = sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0 ? x + y : x;
            y = x;
            x = z;
        }
        return x;
    }


}
