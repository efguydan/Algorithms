package practice

import java.util.*

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/duplicate-zeros/
 * Progress: Done
 */
object DuplicateZeros {

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(1,0,2,3,0,4,5,0)
        duplicateZeros2(arr)
        println(arr.contentToString())

        val arr2 = intArrayOf(1,0,2,3,0,0,4,5) // 1,0,0,2,3,0,0,0
        duplicateZeros2(arr2)
        println(arr2.contentToString())

        val arr3 = intArrayOf(1,5,2,0,6,8,0,6,0)
        duplicateZeros2(arr3)
        println(arr3.contentToString())

        val arr4 = intArrayOf(9,0,9,0,6,0,0,0,1,1,6,5,4,4,8,3,0,0,0,1,5,3,0,0,7,2,1,0,2,0,9,1,0,2,0,0,0,0,0,0,0,6,0,0,7,9,0,8,7,0,9,7,1,0,2,0,0,0,0,9,0,0,0,0)
        duplicateZeros2(arr4)
        println(arr4.contentToString())
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private fun duplicateZeros(arr: IntArray) {
        val queue: Queue<Int> = LinkedList()
        var i = 0
        while(i < arr.size) {
            queue.add(arr[i])
            val curr = queue.remove()
            arr[i] = curr
            if (curr == 0 && i+1 < arr.size) {
                queue.add(arr[++i])
                arr[i] = curr
            }
            i++
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private fun duplicateZeros2(arr: IntArray) {
        var zeros = 0
        var len = arr.lastIndex
        var i = 0
        while (i <= len - zeros) {
            if (i == len-zeros && arr[i] == 0) {
                arr[len--] = 0
                break
            }
            if(arr[i] == 0) zeros++
            i++
        }

        var r = len
        i = len - zeros
        while (i != r) {
            if (arr[i] == 0) arr[r--] = 0
            arr[r--] = arr[i--]
        }
    }

}