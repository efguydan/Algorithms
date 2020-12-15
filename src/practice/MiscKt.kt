package practice

import kotlin.math.max

fun main() {
    println(solution(intArrayOf(1, 1, 5), intArrayOf(6, 5, 8)))
}

fun solution(juice: IntArray, capacity: IntArray): Int {
    var answer = 1
    var maxIndex = -1
    var maxSpace = Int.MIN_VALUE
    for (index in juice.indices) {
        with(max(maxSpace, capacity[index] - juice[index])) {
            if (this > maxSpace) maxIndex = index
            maxSpace = this
        }
    }
    val temp = juice.toMutableList().also {
        it.removeAt(maxIndex)
        it.sort()
    }
    for (eachJuice in temp) {
        maxSpace -= eachJuice
        if (maxSpace >= 0) answer++ else break
    }
    return answer
}