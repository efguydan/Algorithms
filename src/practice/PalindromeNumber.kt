package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/palindrome-number/
 * Progress: Done
 */

object PalindromeNumber {

    @JvmStatic
    fun main(args: Array<String>) {
        println(isPalindrome(121))
        println(isPalindrome(-121))
        println(isPalindrome(10))
    }

    fun isPalindrome(x: Int): Boolean {
        if (x.isNegative()) return false

        var tempX = x
        var reversedX = 0

        while (tempX > 0) {
            reversedX = ((reversedX * 10) + tempX % 10).also { tempX /= 10 }
            if (reversedX.isNegative()) return false
        }
        return reversedX == x
    }

    private fun Int.isNegative() = this < 0

}