package practice.hackerrankinterviewlessons.sorting

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/mark-and-toys/problem
 * Progress: Done
 */
object MarkAndToys {

    fun maximumToys(prices: Array<Int>, k: Int): Int {
        var max = 0
        var rem = k
        prices.sort()

        for (price in prices) {
            rem -= price
            if (rem >= 0) max++ else break
        }

        return max
    }

}