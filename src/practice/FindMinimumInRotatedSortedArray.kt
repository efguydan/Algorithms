package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Progress: Done
 */
object FindMinimumInRotatedSortedArray {

    @JvmStatic
    fun main(args: Array<String>) {
        println(findMin(intArrayOf(4,5,6,7,0,1,2)))
        println(findMin(intArrayOf(11,13,15,17)))
    }

    fun findMin(nums: IntArray): Int {
        for (i in 0 until nums.lastIndex) if (nums[i+1] < nums[i]) return nums[i+1]
        return nums[0]
    }

}