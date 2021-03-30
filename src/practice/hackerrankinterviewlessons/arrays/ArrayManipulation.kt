package practice.hackerrankinterviewlessons.arrays

import java.util.*

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/crush/problem
 * Progress: Done
 */
object ArrayManipulation {

    @JvmStatic
    fun main(args: Array<String>) {
        println(arrayManipulation(3, arrayOf(arrayOf(1,5,3), arrayOf(4,8,7), arrayOf(6,9,1))))
        println(arrayManipulation(3, arrayOf(arrayOf(1,2,100), arrayOf(2,5,100), arrayOf(3,4,100))))

        val string = "29 40 787\n9 26 219\n21 31 214\n8 22 719\n15 23 102\n11 24 83\n14 22 321\n5 22 300\n11 30 832\n5 25 29\n16 24 577\n3 10 905\n15 22 335\n29 35 254\n9 20 20\n33 34 351\n30 38 564\n11 31 969\n3 32 11\n29 35 267\n4 24 531\n1 38 892\n12 18 825\n25 32 99\n3 39 107\n12 37 131\n3 26 640\n8 39 483\n8 11 194\n12 37 502"
        val stringSplit = string.split("\n")
        val inputList = mutableListOf<Array<Int>>()
        for (str in stringSplit) {
            val l = str.split(" ")
            var arr = arrayOf(l[0].toInt(), l[1].toInt(), l[2].toInt())
            inputList.add(arr)
        }

        println(arrayManipulation(0, inputList.toTypedArray()))
    }

    private fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
        val list = queries.toMutableList().sortedWith { o1, o2 -> o1[0] - o2[0] }
        var max = 0L
        var current = 0L

        var keySet = TreeSet<Int>()
        var map = mutableMapOf<Int, Int>()

        var i = 0
        while (i < list.size) {

            var keyToRemove = if (keySet.isNotEmpty()) keySet.first() else -1

            if (keyToRemove != -1 && keyToRemove <= list[i][0]) {
                current -= map[keyToRemove]!!
                map.remove(keyToRemove)
                keySet.remove(keyToRemove)
            } else {
                current += list[i][2]
                max = current.coerceAtLeast(max)
                keySet.add(list[i][1] + 1)
                map[list[i][1] + 1] = (map[list[i][1] + 1] ?: 0) + list[i][2]
                i++
            }
        }

        return max
    }

}