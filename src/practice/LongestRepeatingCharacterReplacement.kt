package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/longest-repeating-character-replacement
 * Concepts: Arrays
 * Progress: Done
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
object LongestRepeatingCharacterReplacement {

    @JvmStatic
    fun main(args: Array<String>) {
        println(characterReplacement("ABAB", 2))
        println(characterReplacement("AABABBA", 1))
    }

    /**
     * The idea is to use a sliding window keeping a int array of all characters in the window.
     * On each window ensuring the constraint is met else, we shrink the window
     */
    fun characterReplacement(s: String, k: Int): Int {
        val sArray = s.toCharArray()
        val countArray = IntArray(26)
        var max = 0

        var start = 0
        var end  = 0

        while (start <= sArray.lastIndex) {
            val chatAtStartIndex = sArray[start] - 'A'
            countArray[chatAtStartIndex]++

            while (start - end + 1 - countArray.maxOrNull()!! > k) {
                val chatAtEndIndex = sArray[end] - 'A'
                countArray[chatAtEndIndex]--
                end++
            }

            max = (start - end + 1).coerceAtLeast(max)
            start++
        }

        return max
    }
}