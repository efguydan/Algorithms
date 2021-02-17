package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/sort-an-array/
 * Time Complexity: O(n log n)
 * Space Complexity: O(n log n)
 * Progress: Done
 */
object SortAnArray {

    /**
     * Main method main used for testing purposes. Tests the input case:
     * nums = [5, 2, 3, 1]
     *
     * output = [1, 2, 3, 5]
     *
     */
    @JvmStatic
    fun main(args: Array<String>) {
        println(sortArray(intArrayOf(5,2,3,1)).contentToString())
    }

    /**
     * Solution method. A sorting algorithm is implemented. Heap sort to be specific.
     */
    fun sortArray(nums: IntArray): IntArray {
        val size = nums.size
        for (i in (size / 2 - 1) downTo 0) heapify(nums, size, i)

        for (i in size-1 downTo 0) {
            nums[0] = nums[i].also { nums[i] = nums[0] }
            heapify(nums, i, 0)
        }

        return nums;
    }

    private fun heapify(nums: IntArray, size: Int, i: Int) {
        var largest = i
        var left = 2 * i + 1
        var right = 2 * i + 2

        if (left < size && nums[left] > nums[largest]) largest = left
        if (right < size && nums[right] > nums[largest]) largest = right

        if (largest != i) {
            nums[i] = nums[largest].also { nums[largest] = nums[i] }
            heapify(nums, size, largest)
        }
    }

}