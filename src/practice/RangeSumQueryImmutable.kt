package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/range-sum-query-immutable/
 * Progress: Done
 */

class NumArray(private val nums: IntArray) {

    private val prefixSums = IntArray(nums.size)

    init {
        for (i in nums.indices) prefixSums[i] = if (i == 0) nums[i] else prefixSums[i-1] + nums[i]
    }

    fun sumRange(i: Int, j: Int): Int = prefixSums[j] - prefixSums[i] + nums[i]

}