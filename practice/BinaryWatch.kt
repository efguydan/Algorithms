package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/binary-watch/
 * Progress: Done
 */

fun main() {
    for (time in readBinaryWatch(2)) println(time)
}

fun readBinaryWatch(count: Int): List<String> {
    val answer = mutableListOf<String>()
    addTimes(answer, count, count, MutableList(10){ _ -> 0}, 0)
    return answer
}

fun addTimes(answer: MutableList<String>, count: Int, rem: Int, currentList: MutableList<Int>, index: Int) {
    if (rem > 10 - index || index < 0) return
    if (rem == 0) {
        val hour = getHour(currentList)
        if (hour > 11) return
        val min = getMin((currentList))
        if (min > 59) return
        answer.add("$hour:${String.format("%02d", min)}")
        return
    }
    currentList[index] = 1
    addTimes(answer, count, rem-1, currentList, index + 1)
    currentList[index] = 0
    addTimes(answer, count, rem, currentList, index + 1)
}

fun getHour(list: List<Int>): Int = 8 * list[0] + 4 * list[1] + 2 * list[2] + list[3]

fun getMin(list: List<Int>) = 32 * list[4] + 16 * list[5] + 8 * list[6] + 4 * list[7] + 2 * list[8] + list[9]