package practice

import java.lang.StringBuilder
import kotlin.math.max

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/decode-ways/
 * Progress: Done
 */
object DecodeWays {

    @JvmStatic
    fun main(args: Array<String>) {
        println(numDecodings("2611055971756562"))
    }

    fun numDecodings(s: String): Int {
        var answer = 0

        var combs = breakInputIntoPossibleCombinations(s).map {
            if (it.length == 2 && Character.getNumericValue(it[1]) == 0) return@map 1
            it.length
        }

        val fib = combs.getMaxValue().coerceAtLeast(2).generateFibonacci()
        combs = combs.map { fib[it] }

        for (i in combs) answer = answer.coerceAtLeast(1) * i

        return answer
    }

    private fun breakInputIntoPossibleCombinations(s: String): List<String> {
        var possibleList = mutableListOf<String>()
        val intArray = s.toCharArray().map { Character.getNumericValue(it) }
        var sb = StringBuilder()

        for (i in intArray) {
            if (i == 0) {
                if (sb.isEmpty()) return listOf()
                val c = sb[sb.lastIndex]
                sb.removeRange(sb.lastIndex, sb.length).also {
                    if (it.isNotEmpty()) possibleList.add(it.toString())
                }
                sb.clear().append(c).append(i)
                possibleList.add(sb.toString())
                sb.clear()
            } else if (i > 6) {
                if (sb.isNotEmpty() && sb.last() != '1') {
                    possibleList.add(sb.toString())
                    sb.clear()
                }
                sb.append(i)
                possibleList.add(sb.toString())
                sb.clear()
            } else {
                sb.append(i)
                if (i > 2) {
                    possibleList.add(sb.toString())
                    sb.clear()
                }
            }
        }
        if (sb.isNotEmpty()) {
            possibleList.add(sb.toString())
            sb.clear()
        }

        return possibleList
    }

    private fun List<Int>.getMaxValue(): Int {
        var max = 0
        for (num in this) max = max(max, num)
        return max
    }

    private fun Int.generateFibonacci() : Array<Int> {
        val fib = Array((this+1)) { 1 }
        for (i in 2..fib.lastIndex) fib[i] = fib[i-1] + fib[i-2]
        return fib
    }

}