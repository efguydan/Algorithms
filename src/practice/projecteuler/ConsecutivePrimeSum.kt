package practice.projecteuler

import java.lang.Integer.max

/**
 * @author EfeDaniel
 * Link: https://projecteuler.net/problem=50
 * Progress: Done
 */
object ConsecutivePrimeSum {

    @JvmStatic
    fun main(args: Array<String>) {
        println(consecutivePrimeSum(100))
        println(consecutivePrimeSum(1000))
        println(consecutivePrimeSum(1_000_000))
    }

    private fun consecutivePrimeSum(n: Int): Int {
        val primeSet = getPrimesUpTo(n)
        val primeList = primeSet.toList()
        var maxCount = -1
        var maxPrime = -1

        primeList.forEachIndexed { index, _ ->
            var sum = 0
            var current = index
            while (current < primeList.lastIndex) {
                sum += primeList[current]
                current++
                if (primeSet.contains(sum)) maxCount = max(current-index, maxCount).also {
                    if (it > maxCount) maxPrime = sum
                }
                if (sum > n) break
            }
        }

        return maxPrime
    }

    // sieve of Eratosthenes

    private fun getPrimesUpTo(n: Int): Set<Int> {
        val length = n+1
        val primeArray = IntArray(length).also { it[0] = 1; it[1] = 1 }
        for (i in 2 until length) {
            if (primeArray[i] != 0) continue
            var k = i * 2
            while (k < length) {
                primeArray[k] = 1
                k+=i
            }
        }
        return primeArray.mapIndexed { index, i -> if (i == 0) index else 0 }.filter { it != 0 }.toSet()
    }

}