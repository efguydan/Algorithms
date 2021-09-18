package practice

/**
 *  @author EfeDaniel
 * Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Progress: Done
 */
object FindAllNumbersDisappearedInAnArray {

    @JvmStatic
    fun main(args: Array<String>) {
        println(findDisappearedNumbers(intArrayOf(4,3,2,7,8,2,3,1)))
        println(findDisappearedNumbers(intArrayOf(1,1)))
    }

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val answer = mutableListOf<Int>()

        for (i in nums.indices) {
            if (nums[i] == -1) continue

            var jump = nums[i]
            while(jump != -1) jump = nums[jump-1].also { nums[jump-1] = -1 }
        }
        for (i in nums.indices) if (nums[i] != -1) answer.add(i+1)
        return answer
    }

}