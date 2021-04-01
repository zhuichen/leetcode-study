package com.czy.leetcode.dyp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 *  
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
 * 0 <= num < 231
 */
class Solution4 {

    public static void main(String[] args) {
        System.out.println(translateNum(12258));

    }

    public static int translateNum(int num) {
        String[] split = String.valueOf(num).split("");
        int sum = 0;
        List<Integer> list = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return sum;
    }

}
