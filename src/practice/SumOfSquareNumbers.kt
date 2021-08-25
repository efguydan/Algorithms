package practice

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/sum-of-square-numbers/
 * Progress: Done
 */
object SumOfSquareNumbers {

    @JvmStatic
    fun main(args: Array<String>) {
        println(judgeSquareSum(0))
    }

    fun judgeSquareSum(c: Int): Boolean {
        var pow = 0.0
        var i = 0

        while (i <= c/2 && pow <= c) {
            pow = i.pow(2)
            val complement = c - pow
            if (complement.isPerfectSquare()) return true
            i++
        }
        return false
    }

    private fun Double.isPerfectSquare(): Boolean {
        return sqrt(this).toInt().toDouble().pow(2) == this
    }

    private fun Int.pow(n: Int) = toDouble().pow(n)


}