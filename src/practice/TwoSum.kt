package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/two-sum/
 * Progress: Done
 */
object TwoSum {

    /**
     * The idea is to keep a map of found numbers and their indices. On every new integer we meet,
     * try to see if its complement has already been found
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            val complement = target - num
            map[complement]?.let {
                return intArrayOf(index, it)
            } ?: kotlin.run {
                map[num] = index
            }
        }
        return intArrayOf(0, 0)
    }
}