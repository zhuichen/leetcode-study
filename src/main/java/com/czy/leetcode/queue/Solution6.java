package com.czy.leetcode.queue;

import java.util.PriorityQueue;

/**
 * 最低加油次数
 * <p>
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 * <p>
 * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
 * <p>
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 * <p>
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 * <p>
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 * <p>
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 1, startFuel = 1, stations = []
 * 输出：0
 * 解释：我们可以在不加油的情况下到达目的地。
 * 示例 2：
 * <p>
 * 输入：target = 100, startFuel = 1, stations = [[10,100]]
 * 输出：-1
 * 解释：我们无法抵达目的地，甚至无法到达第一个加油站。
 * 示例 3：
 * <p>
 * 输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * 输出：2
 * 解释：
 * 我们出发时有 10 升燃料。
 * 我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
 * 然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
 * 并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
 * 我们沿途在1两个加油站停靠，所以返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target, startFuel, stations[i][1] <= 10^9
 * 0 <= stations.length <= 500
 * 0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 */
class Solution6 {

    /**
     * 很巧妙
     *
     * 关键点在于：怎么样才能加油最少次数，那就是肯定每次加油都是尽可能加最多。动态求极值
     *
     * 1、先去到第一个到不了的加油站A，然后再从之前的加油站加油，从大油量到小油量开始加，知道能到达A
     *
     * 2、按照1步骤，一直当达到最后一个加油C。然后再从之前没有加过油的加油站，一直加油加油到终点
     *
     *
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            return startFuel >= target ? 0 : -1;
        }

        // 定义次数 ans，车内油量 cur
        int ans = 0, cur = startFuel;
        // 定义 pq 用来在车厢箱保存燃油
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < stations.length; i++) {
            // 车上没油啦 需要到车厢找最大的一桶油来加满
            while (cur < stations[i][0]) {
                Integer fuel = pq.poll();
                // 车厢没油了 mission failed
                if (fuel == null) {
                    return -1;
                }
                // 行驶距离
                cur += fuel;
                ans++;
            }
            pq.offer(stations[i][1]);
        }
        // 判断是否到达目的地
        while (cur < target) {
            Integer fuel = pq.poll();
            if (fuel == null) {
                return -1;
            }
            cur += fuel;
            ans++;
        }
        return ans;
    }


}
