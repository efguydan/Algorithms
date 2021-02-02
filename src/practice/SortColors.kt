package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/sort-colors
 * Progress: Done
 */
object SortColors {

    /**
     * Solution Method. Just applies bubble sort on the input array
     */
    fun sortColors(nums: IntArray) {
        nums.bubbleSort()
    }

    /**
     * Extension function to bubble sort an Int Array
     */
    fun IntArray.bubbleSort() {
        if (size < 2) return
        var swapped = true
        while (swapped) {
            swapped = false
            for (i in 1..lastIndex) {
                if (this[i] < this[i-1]) {
                    this[i] = this[i-1].also { this[i-1] = this[i] }
                    swapped = true
                }
            }
        }
    }

}