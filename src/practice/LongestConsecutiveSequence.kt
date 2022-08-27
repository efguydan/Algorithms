package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/submissions/
 * Concepts: Prefix Sums
 * Progress: Done
 */
object LongestConsecutiveSequence {

    /**
     * The idea is to find the first number of each sequence by checking if the previous number is present in the set.
     * Then using the same set, check the longest sequence from that number
     */
    fun longestConsecutive(nums: IntArray): Int {
        var max = 0
        val numSet = nums.toSet()

        for (num in nums) {
            if (numSet.contains(num - 1)) continue

            var count = 1
            while (numSet.contains(num + count)) count++

            max = count.coerceAtLeast(max)
        }
        return max
    }
}