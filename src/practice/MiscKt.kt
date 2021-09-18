package practice

import java.util.*

object MiscKt {

    @JvmStatic
    fun main(args: Array<String>) {
        println(getPair(listOf("abc", "bca", "dbe")).contentToString())
        println(getPair(listOf("zzzz", "ferz", "zdsr", "fgtd")).contentToString())
    }

    fun getPair(strings: List<String>): IntArray {
        val map = mutableMapOf<String, Int>()
        for (i in strings.indices) {
            val arr = strings[i].toCharArray()
            for (j in arr.indices) {
                val key = getKey(arr[j], j)
                if (map.containsKey(key)) {
                    return intArrayOf(map[key] ?: 0, i, j)
                }
                map[key] = i
            }
        }
        return intArrayOf()
    }

    private fun getKey(char: Char, position: Int): String {
        return buildString {
            append(char)
            append(position)
        }
    }

}

