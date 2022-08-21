package practice

import kotlin.math.min

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/min-cost-climbing-stairs/
 * Concepts: DP
 * Progress: Done
 */
object MinCostClimbingStairs {

    @JvmStatic
    fun main(args: Array<String>) {
        println(minCostClimbingStairs(intArrayOf(1,100,1,1,1,100,1,1,100,1)))
    }

    /**
     * The idea is the get the cheapest way to reach each point by trying to get to it from the previous point and the
     * second previous point. The minimum of these costs is the cheapest way to get to each point.
     */
    fun minCostClimbingStairs(costs: IntArray): Int {
        if (costs.size < 2) return 0

        var prev = 0
        var secondPrev = 0

        for (cost in costs) {
            var temp = min(prev + cost, secondPrev + cost)
            secondPrev = prev
            prev = temp
        }

        return min(prev, secondPrev)
    }
}