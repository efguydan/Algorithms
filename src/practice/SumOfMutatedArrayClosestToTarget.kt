package practice

import kotlin.math.abs

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 * Progress: Done
 */
object SumOfMutatedArrayClosestToTarget {

    @JvmStatic
    fun main(args: Array<String>) {
        println(findBestValue(intArrayOf(4,9,3), 10))
        println(findBestValue(intArrayOf(2,3,5), 10))
        println(findBestValue(intArrayOf(60864,25176,27249,21296,20204), 56803))
        println(findBestValue(intArrayOf(1547,83230,57084,93444,70879), 71237))
    }

    fun findBestValue(arr: IntArray, target: Int): Int {
        var minDiff = Int.MAX_VALUE
        var answer = 0
        var currSum = 0
        var sorted = arr.sorted()

        sorted.forEachIndexed { index, num ->
            val space = arr.size - index
            val currentTarget = target-currSum
            var perfectNumber = with(currentTarget/ space) {
                var floor = this
                var ceil = this + 1
                if (currentTarget - floor * space > ceil * space - currentTarget) ceil else floor
            }

            perfectNumber = perfectNumber
                .coerceAtMost(num)
                .coerceAtLeast(sorted.getOrNull(index-1) ?: 0)

            (abs(target - (currSum + perfectNumber * space))).let {
                if (it < minDiff) {
                    minDiff = it
                    answer = perfectNumber
                }
            }

            currSum += num
        }

        return answer
    }

}