package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/palindromic-substrings
 * Concepts: Strings, Array
 * Progress: Done
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
object PalindromicSubstrings {

    @JvmStatic
    fun main(args: Array<String>) {
        println(countSubstrings("aaa"))
    }

    /**
     * Starting from each index, count the number of palindromes that has the current index as their middle by
     * expanding outwards
     */
    private fun countSubstrings(s: String): Int {
        var result = 0

        for (i in s.indices) {
            result += countPalindromes(s, i, i)
            result += countPalindromes(s, i, i+1)
        }

        return result
    }

    private fun countPalindromes(s: String, start: Int, end: Int): Int {
        var result = 0
        var left = start
        var right = end

        while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
            result++
            left--
            right++
        }

        return result
    }
}
