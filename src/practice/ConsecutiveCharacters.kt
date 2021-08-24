package practice

import kotlin.math.max

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/consecutive-characters/
 * Progress: Done
 */
object ConsecutiveCharacters {

    fun maxPower(s: String): Int {
        var charArray = s.toCharArray()
        if (charArray.isEmpty()) return 0

        var current = 1
        var max = 1

        for (i in 1..charArray.lastIndex) {
            if (charArray[i] == charArray[i-1]) {
                current++
                max = max(current, max)
            } else {
                current = 1
            }
        }
        return max
    }

}