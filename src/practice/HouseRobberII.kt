package practice

import kotlin.math.max

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/house-robber-ii/
 * Concepts: DP
 * Progress: Done
 */
object HouseRobberII {

    @JvmStatic
    fun main(args: Array<String>) {
        println(rob(intArrayOf(2,3,2)))
    }

    /**
     * run the house robber I solution on the set twice, removing the first and last elements in the different runs
     */
    fun rob(nums: IntArray): Int {
        if (nums.size < 2) return nums.firstOrNull() ?: 0

        val firstSampleSize = nums.copyOfRange(0, nums.lastIndex)
        val secondSampleSize = nums.copyOfRange(1, nums.size)

        return max(houseRobberI(firstSampleSize), houseRobberI(secondSampleSize))
    }

    /**
     * The idea is to maximise the gains at a current location by considering both possible ways to get to that house
     */
    private fun houseRobberI(nums: IntArray): Int {
        var current = 0
        var prev = 0

        for (num in nums) {
            var temp = max(prev + num, current)
            prev = current
            current = temp
        }
        return current
    }
}