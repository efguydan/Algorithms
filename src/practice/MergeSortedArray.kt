package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/merge-sorted-array/
 * Progress: Done
 */
object MergeSortedArray {

    @JvmStatic
    fun main(args: Array<String>) {
        val n1 = intArrayOf(1,0)
        val n2 = intArrayOf(2)
        merge(n1, 1, n2, 1)
        println(n1.contentToString())
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var j = 0
        for (i in nums1.indices) {
            if (j > nums2.lastIndex) break
            if (nums2[j] < nums1[i]) {
                nums1.shiftToRight(i)
                nums1[i] = nums2[j]
                j++
            }
        }
        for (i in m+j..nums1.lastIndex) {
            nums1[i] = nums2[j]
            j++
        }
    }

    private fun IntArray.shiftToRight(fromIndex: Int) {
        for (i in lastIndex downTo fromIndex+1) {
            this[i] = this[i-1]
        }
    }

}