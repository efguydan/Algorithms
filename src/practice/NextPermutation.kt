package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/next-permutation/
 * Concepts: Arrays
 * Progress: Done
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */
object NextPermutation {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(1,3,2)
        nextPermutation(array)
        println(array.contentToString())
    }

    /**
     * The idea is to
     * - loop from the back
     * - find the first index where the number is going down like from 3 to 1
     * - then find the next largest number from the current index in the array to replace said index
     * - sort to the right of that number to get the lowest number it can form
     *
     * if no such index is found, just sort the array to reset it
     */
    private fun nextPermutation(nums: IntArray): Unit {
        if (nums.size < 2) return
        for (i in nums.lastIndex - 1 downTo 0) {
            if (nums[i] < nums[i + 1]) {
                rearrange(nums, i)
                break
            } else if (i == 0) {
                nums.sort()
            }
        }
    }

    private fun rearrange(nums: IntArray, startIndex: Int) {
        var switchIndex = startIndex + 1
        for (i in switchIndex .. nums.lastIndex) {
            if (nums[i] > nums [startIndex] && nums[i] < nums[switchIndex]) switchIndex = i
        }
        nums[startIndex] = nums[switchIndex].also { nums[switchIndex] = nums[startIndex] }
        nums.sort(fromIndex = startIndex + 1)
    }
}
