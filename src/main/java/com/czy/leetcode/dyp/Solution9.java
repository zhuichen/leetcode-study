package com.czy.leetcode.dyp;


import java.util.Arrays;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *  
 * <p>
 * 提示：
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 */
class Solution9 {


    /**
     * [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * 路径 1→3→5→2→1
     * 当 i=0 && j=0 时，dp[0][0] = grid[0][0]
     * 当 i=0 && j!=0 时，dp[i][j] = grid[i][j] + dp[i][j-1]
     * 当 i!=0 && j=0 时，dp[i][j] = grid[i][j] + dp[i-1][j]
     * 当 i!=0 && j!=0 时，dp[i][j] = grid[i][j] + max(dp[i-1][j], dp[i][j-1])
     * <p>
     * <p>
     * d[0][0]=grid[0][0]
     * d[0][1]=grid[0][1]
     * d[1][0]=grid[1][0]
     * d[1][1]=d[0][1]+d[1][0]
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }


}
