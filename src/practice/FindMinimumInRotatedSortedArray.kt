package practice

import kotlin.math.min

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Concepts: Array
 * Progress: Done
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
object FindMinimumInRotatedSortedArray {

    @JvmStatic
    fun main(args: Array<String>) {
        println(findMin(intArrayOf(4,5,6,7,0,1,2)))
        println(findMin(intArrayOf(11,13,15,17)))
    }

    fun findMin2(nums: IntArray): Int {
        for (i in 0 until nums.lastIndex) if (nums[i+1] < nums[i]) return nums[i+1]
        return nums[0]
    }

    /**
     * we run a binary search. We try to always find the half that is sorted, get the min from there and proceed
     * to search in the other half instead.
     * We always keep track of the minimum we have ever seen
     */
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        var answer = Int.MAX_VALUE

        while(left <= right) {
            if (nums[left] < nums[right]) {
                answer = min(answer, nums[left])
                break
            }

            val mid = (left + right) / 2

            if (nums[left] <= nums[mid]) {
                answer = min(answer, nums[left])
                left = mid + 1
            } else {
                answer = min(answer, nums[mid])
                right = mid - 1
            }
        }

        return answer
    }

}