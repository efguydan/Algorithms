package practice.codilitylessons.others

import kotlin.math.max

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/90-tasks_from_indeed_prime_2015_challenge/flood_depth/
 * Codility Report Link: https://app.codility.com/demo/results/training6V4DH2-NRD/
 * Progress: Done
 */
object FloodDepth {

    @JvmStatic
    fun main(args: Array<String>) {
        println(solution(intArrayOf(1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2)))
        println(solution(intArrayOf(3,1,2)))
    }

    fun solution(a: IntArray): Int {
        var maxHeight = 0
        var minHeight = 0
        var maxDepth = 0

        for (height in a) {
            var depth = 0;
            when {
                height > maxHeight -> {
                    depth = maxHeight - minHeight
                    maxHeight = height
                    minHeight = height
                }
                height < minHeight -> minHeight = height
                else -> depth = height - minHeight
            }
            maxDepth = max(depth, maxDepth)
        }

        return maxDepth
    }

}