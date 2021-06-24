package practice.hackerrankinterviewlessons.sorting

import java.util.*

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 * Huge Credit: https://medium.com/weekly-webtips/sorting-code-challenge-breakdown-19229b32be02
 * Progress: Done
 */
object FraudulentActivityNotifications {

    @JvmStatic
    fun main(args: Array<String>) {
        println(activityNotifications(arrayOf(2, 3, 4, 2, 3, 6, 8, 4, 5), 5))
    }

    fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
        var answer = 0

        val countArr = Array(201) {0}

        for (i in 0 until d) countArr[expenditure[i]]++

        for (i in d until expenditure.lastIndex) {
            val median = getMedianDoubled(countArr, d)
            if (expenditure[i] >= median) answer++
            countArr[expenditure[i-d]]--
            countArr[expenditure[i]]++
        }

        return answer
    }

    private fun getMedianDoubled(countArr: Array<Int>, d: Int): Int {
        var sum = 0
        for (i in countArr.indices) {
            sum += countArr[i]
            if (sum * 2 == d) return i * 2 + 1
            if (sum * 2 > d) return  i * 2
        }
        return 0
    }

//    private fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
//        var answer = 0
//        if (expenditure.size < d) return answer
//
//        val list = mutableListOf<Int>()
//        for (i in 0 until d) list.add(expenditure[i])
//        list.sort()
//
//        for (i in d..expenditure.lastIndex) {
//            if (expenditure[i] >= getMedianDoubled(list)) answer++
//            mutateList(list, expenditure[i-d], expenditure[i])
//        }
//
//        return answer
//    }
//
//    private fun mutateList(currentList: MutableList<Int>, remove: Int, add: Int) {
//        var indexToRemove = -1
//        var indexToAdd = currentList.lastIndex
//        currentList.forEachIndexed { index, i ->
//            if (i == remove) indexToRemove = index
//            if (i >= add) indexToAdd = index
//        }
//
//        currentList.removeAt(indexToRemove)
//        currentList.add(indexToAdd, add)
//    }
//
//    private fun getMedianDoubled(list: List<Int>): Int {
//        if (list.isEmpty()) return 0
//        val size = list.size
//        return if (size.isEven()) {
//            (list[size/2] + list[size/2 - 1])
//        } else {
//            list[size/2] * 2
//        }
//    }
//
//    private fun Int.isEven(): Boolean = this % 2 == 0

}