package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/subsets/
 * Concepts: Arrays
 * Progress: Done
 * Time Complexity: O(2^n)
 * Space Complexity: O(2^n)
 */
object Subsets {

    @JvmStatic
    fun main(args: Array<String>) {
        println(subsets(intArrayOf(1,2,3)))
    }

    /**
     * Starting with an empty array, add each element's subsets by concatenating it with the current
     * elements of the answer array
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        val answer: MutableList<List<Int>> = mutableListOf(emptyList())

        for (i in nums) {
            val setsForI: MutableList<List<Int>> = mutableListOf()
            for (set in answer) {
                setsForI.add(set + listOf(i))
            }
            answer.addAll(setsForI)
        }

        return answer
    }
}