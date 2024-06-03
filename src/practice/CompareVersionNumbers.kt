package practice

import kotlin.math.max

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/compare-version-numbers
 * Concepts: Strings, Array
 * Progress: Done
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
object CompareVersionNumbers {

    @JvmStatic
    fun main(args: Array<String>) {
        println(compareVersion("1.2", "1.10"))
        println(compareVersion("1.01", "1.001"))
    }

    private fun compareVersion(version1: String, version2: String): Int {
        val array1 = version1.split(".")
        val array2 = version2.split(".")

        var i = 0
        while (i < max(array1.size, array2.size)) {
            val left = array1.getOrNull(i)?.toInt() ?: 0
            val right = array2.getOrNull(i)?.toInt() ?: 0
            if (left > right) {
                return 1
            } else if (left < right) {
                return -1
            } else {
                i++
            }
        }
        return 0
    }
}