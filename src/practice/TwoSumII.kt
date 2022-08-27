package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Concepts: Two Pointer
 * Progress: Done
 */
object TwoSumII {

    @JvmStatic
    fun main(args: Array<String>) {
        println(twoSum(intArrayOf(2,7,11,15), 9).contentToString())
    }

    /**
     * Two Pointer solution. Since the array is sorted, we can keep coming more narrow until we get our
     * target sum
     */
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var a = 0
        var b = numbers.lastIndex

        while (a != b) {
            val sum = numbers[a] + numbers[b]
            when {
                sum == target -> return intArrayOf(a+1, b+1)
                sum < target -> a++
                sum > target -> b--
            }
        }
        return intArrayOf(a+1, b+1)
    }
}