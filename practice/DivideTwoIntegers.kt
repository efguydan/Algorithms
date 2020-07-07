package practice

/**
 * @author EfeDaniel
 * Link: leetcode.com/problems/divide-two-integers
 * Progress: Done
 */

fun main() {
    println(divide(7, 2))
    println(divide(7, -2))
    println(divide(-1, 1))
    println(divide(1, -1))
    println(divide(-2147483648, -1))
}

fun divide(dividend: Int, divisor: Int): Int {
    var answer = 0
    if (divisor == 1) return dividend
    var mutableDivisor = if (divisor > 0) divisor - divisor - divisor else divisor
    var mutableDividend = if (dividend > 0) dividend - dividend - dividend else dividend
    if (divisor == -1) {
        return if (dividend == -2147483648) 2147483647 else dividend - dividend - dividend
    }

    while (mutableDividend <= mutableDivisor) {
        if (answer < 2147483647) answer++
        mutableDividend -= mutableDivisor
    }
    return if ((divisor<0 && dividend>0) || (divisor>0 && dividend<0)) answer - answer - answer else answer
}