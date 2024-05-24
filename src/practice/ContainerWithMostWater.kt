package practice

import kotlin.math.max
import kotlin.math.min

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/palindromic-substrings
 * Concepts: Arrays
 * Progress: Done
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
object ContainerWithMostWater {

    @JvmStatic
    fun main(args: Array<String>) {
        println(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    }

    /**
     * Using a two pointer from both ends of the array, the bottleneck is always the lowest number so move that index
     */
    fun maxArea(height: IntArray): Int {
        var maxArea = 0

        var left = 0
        var right = height.lastIndex

        while (left <= right) {
            val area = min(height[left], height[right]) * (right - left)
            maxArea = max(area, maxArea)
            if (height[left] > height[right]) right-- else left++
        }

        return maxArea
    }
}