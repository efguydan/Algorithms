package practice

import java.lang.Exception
import kotlin.math.min

/**
 * @author EfeDaniel
 * Link: https://www.hackerearth.com/problem/algorithm/matching-strings-8/
 * Progress: Done
 */
object StringMatching {

    @JvmStatic
    fun main(args: Array<String>) {
        stringMatching()
    }

    fun stringMatching() {
        try {
            val count = readLine()!!.toInt()
            for (i in 0 until count) {
                val s1 = readLine()!!
                val s2 = readLine()!!
                println(matches(s1, s2))
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }

    private fun matches(s1: String, s2: String): Int {
        var answer = 0;
        for (i in 0 until min(s1.length, s2.length)) {
            if (s1[i] == s2[i]) answer++
        }
        return answer
    }

}