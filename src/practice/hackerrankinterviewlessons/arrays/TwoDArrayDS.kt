package practice.hackerrankinterviewlessons.arrays

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/2d-array/problem
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Progress: Done
 */
object TwoDArrayDS {

    @JvmStatic
    fun main(args: Array<String>) {

    }

    fun hourglassSum(arr: Array<Array<Int>>): Int {
        var max = Int.MIN_VALUE
        for (i in 0 until 4) {
            for (j in 0 until 4) {
                val top = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                val mid = arr[i+1][j+1]
                val bottom = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]

                max = (top + mid + bottom).coerceAtLeast(max)
            }
        }
        return max
    }

}