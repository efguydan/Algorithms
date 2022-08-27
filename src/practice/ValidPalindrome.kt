package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/valid-palindrome
 * Concepts: Two Pointers
 * Progress: Done
 */
object ValidPalindrome {

    @JvmStatic
    fun main(args: Array<String>) {
        println(isPalindrome("0P"))
    }

    fun isPalindrome(s: String): Boolean {
        var characterList = s.toLowerCase().toCharArray().toList().filter { it.isLetterOrDigit() }

        println(characterList)
        for (i in 0 until characterList.size / 2) {
            if (characterList[i] != characterList[characterList.lastIndex - i]) return false
        }
        return true
    }
}