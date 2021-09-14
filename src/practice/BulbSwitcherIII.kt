package practice

import kotlin.math.max

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/bulb-switcher-iii/
 * Progress: Done
 */
object BulbSwitcherIII {

    @JvmStatic
    fun main(args: Array<String>) {
        println(numTimesAllBlue(intArrayOf(2,1,3,5,4)))
    }

    fun numTimesAllBlue(light: IntArray): Int {
        var answer = 0
        var max = -1

        for (i in light.indices) {
            max = max(light[i], max)
            if (i+1 == max) answer++
        }

        return answer
    }

}