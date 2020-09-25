package practice

import kotlin.math.max

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * Progress: Done
 */

object BestTimeToBuyAndSellStock {

    @JvmStatic
    fun main(args: Array<String>) {
        println(maxProfit(intArrayOf(7,1,5,3,6,4)))
    }

    private fun maxProfit(prices: IntArray): Int {
        var answer = 0
        var currentMin = prices.getOrElse(0) { 0 }

        for (price in prices) {
            if (price < currentMin) currentMin = price
            answer = max(answer, price - currentMin)
        }

        return answer
    }

}