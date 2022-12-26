package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 * Concepts: Arrays
 * Progress: Done
 */
object TopKFrequentElements {

    @JvmStatic
    fun main(args: Array<String>) {
        println(topKFrequent(intArrayOf(1,1,1,2,2,3), 2).contentToString())
        println(topKFrequent(intArrayOf(1), 1).contentToString())
    }

    /**
     * The idea is to find the count of each item, then distribute each count into an array of keys. where the
     * key is the count. Then get the highest k.
     */
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val answer = mutableListOf<Int>()

        val numberCount = mutableMapOf<Int, Int>()
        nums.forEach { numberCount[it] = (numberCount[it] ?: 0) + 1 }

        val array = Array<MutableList<Int>>(nums.size+1) { mutableListOf() }
        for (key in numberCount.keys) {
            val count = numberCount[key] ?: 0
            array[count].add(key)
        }

        var i = array.lastIndex
        while (answer.size < k && i > 0) {
            answer.addAll(array[i])
            i--
        }

        return answer.toIntArray()
    }
}