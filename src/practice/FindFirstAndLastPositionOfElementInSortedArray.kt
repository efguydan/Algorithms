package practice

object FindFirstAndLastPositionOfElementInSortedArray {

    @JvmStatic
    fun main(args: Array<String>) {
        println(searchRange(intArrayOf(1,2,3), 2))
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        val answer = intArrayOf(-1, -1)

        val (mid, start, end) = findElementPosition(nums, target)

        println(mid)
        println(start)
        println(end)

        return answer
    }

    fun getStart(nums: IntArray, target: Int, start: Int, end: Int): Int {
        if (start == 0) return start
        var mutableStart = start
        var mutableEnd = end
        var mid = (start + end) / 2

        while (mutableStart <= mutableEnd) {
            if (nums[mid] == target) {

            }
        }

        return mid
    }

    fun findElementPosition(nums: IntArray, target: Int): Triple<Int, Int, Int> {
        var start = 0
        var end = nums.lastIndex
        while(start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] == target) {
                return Triple(mid, start, end)
            } else if (nums[mid] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return Triple(-1, -1, -1)
    }
}