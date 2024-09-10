package practice

import kotlin.math.min

object SearchInRotatedSortedArray {

    @JvmStatic
    fun main(args: Array<String>) {
        println(search(intArrayOf(4,5,6,7,0,1,2), 0))
        println(search(intArrayOf(4,5,6,7,0,1,2), 3))
        println(search(intArrayOf(1), 0))
        println(search(intArrayOf(3,1), 3))
    }

    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while(left <= right) {
            val mid = (left + right) / 2

            if (nums[mid] == target) {
                return mid
            } else if (nums[left] <= nums[right]) {
                when {
                    nums[mid] == target -> return mid
                    nums[mid] < target -> left = mid + 1
                    nums[mid] > target -> right = mid - 1
                }
            } else if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }

        return -1
    }
}