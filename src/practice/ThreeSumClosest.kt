package practice

import kotlin.math.abs

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/3sum-closest
 * Concepts: Array
 * Progress: Done
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
object ThreeSumClosest {

    @JvmStatic
    fun main(args: Array<String>) {
        println(threeSumClosest(intArrayOf(4,0,5,-5,3,3,0,-4,-5), -2))
    }

    /**
     * THe idea is basically three sum with the sort approach. But using the provided target as opposed to zero when
     * solving the original three sum
     */
    private fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var result = nums[0] + nums[1] + nums[2]

        for (i in 0 .. nums.lastIndex - 2) {
            var start = i + 1
            var end = nums.lastIndex


            while(start < end) {
                var sum = nums[i] + nums[start] + nums[end]
                if (abs(sum - target) < abs(result - target)) result = sum

                if (sum > target) end-- else start++
            }
        }

        return result
    }
}