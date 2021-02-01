package practice

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/insertionsort2/problem
 * Progress: Done
 */
object InsertionSortPart2 {

    /**
     * Main method Used mainly for testing purposes. Tests the input case:
     * n = 7
     * arr = [3, 4, 7, 5, 6, 2, 1]
     */
    @JvmStatic
    fun main(args: Array<String>) {
        insertionSort2(7, arrayOf(3, 4, 7, 5, 6, 2, 1))
    }

    /**
     * Solution Method
     * Takes each value in the array and tracks back the previous indexes to find
     * the correct position in the array.
     * At the end of each iteration, it prints the current state of the array.
     */
    fun insertionSort2(n: Int, arr: Array<Int>) {
        for (i in 1..arr.lastIndex) {
            var j = i
            while (j > 0 && arr[j] < arr[j-1]) {
                arr[j] = arr[j-1].also { arr[j-1] = arr[j] }
                j--
            }
            println(arr.joinToString(separator = " "))
        }
    }

}