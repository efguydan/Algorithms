package practice

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 * Progress: Done
 */
object MinimumSwaps {

    @JvmStatic
    fun main(args: Array<String>) {
        println(minimumSwaps(arrayOf(7,1,3,2,4,5,6)))
        println(minimumSwaps(arrayOf(4,3,1,2)))
        println(minimumSwaps(arrayOf(2,3,4,1,5)))
        println(minimumSwaps(arrayOf(1,3,5,2,4,6,7)))
        var arr = "2 31 1 38 29 5 44 6 12 18 39 9 48 49 13 11 7 27 14 33 50 21 46 23 15 26 8 47 40 3 32 22 34 42 16 41 24 10 4 28 36 30 37 35 20 17 45 43 25 19".split(" ")
        var intList = arr.map {
            it.toInt()
        }
        println(minimumSwaps(intList.toTypedArray()))
    }

    fun minimumSwaps(arr: Array<Int>): Int {
        var swaps = 0

        for (i in arr.indices) {
            var position = i+1
            while (arr[i] != position) {
                val other = arr[i]
                arr[other-1] = other.also { arr[i] = arr[other-1] }
                swaps++
            }
        }

        return swaps
    }
}