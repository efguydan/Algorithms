package practice

import kotlin.math.max

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/maximum-product-subarray
 * Concepts: Array
 * Progress: Done
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
object MaximumProductSubarray {

    fun maxProduct(nums: IntArray): Int {
        var answer = Int.MIN_VALUE

        var forward = 1
        var backward = 1
        for (i in nums.indices) {
            forward *= nums[i]
            backward *= nums[nums.lastIndex - i]

            answer = max(answer, forward)
            answer = max(answer, backward)

            if (forward == 0) forward = 1
            if (backward == 0) backward = 1
        }
        
        return answer
    }
}