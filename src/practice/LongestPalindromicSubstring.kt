package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/longest-palindromic-substring
 * Concepts: Strings, Array
 * Progress: Done
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
object LongestPalindromicSubstring  {

    @JvmStatic
    fun main(args: Array<String>) {
        println(longestPalindrome("babad"))
    }

    /**
     * Finding the longest palindrome for each substring that has the current index in the middle, compare that with the current longest
     */
    fun longestPalindrome(s: String): String {
        var longestPalindrome = ""

        for (i in s.indices) {
            findPalindrome(s, i, i).let { if (it.length > longestPalindrome.length) longestPalindrome = it }
            findPalindrome(s, i, i+1).let { if (it.length > longestPalindrome.length) longestPalindrome = it }
        }

        return longestPalindrome
    }

    private fun findPalindrome(s: String, start: Int, end: Int): String {
        var mutableStart = start
        var mutableEnd = end
        var longestPalindrome = ""

        while (mutableStart >= 0 && mutableEnd <= s.lastIndex && s[mutableStart] == s[mutableEnd]) {
            longestPalindrome = s.substring(mutableStart, mutableEnd+1)
            mutableStart--
            mutableEnd++
        }

        return longestPalindrome
    }
}