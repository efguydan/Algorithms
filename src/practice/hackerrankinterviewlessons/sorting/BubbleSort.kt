package practice.hackerrankinterviewlessons.sorting

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
 * Progress: Done
 */
object BubbleSort {

    fun countSwaps(a: Array<Int>) {
        var swaps = 0

        var swapMade = true
        while (swapMade) {
            swapMade = false
            for (i in 0 until a.lastIndex) {
                if (a[i] > a[i+1]) {
                    swapMade = true
                    swaps++
                    a[i] = a[i+1].also { a[i+1] = a[i] }
                }
            }
        }

        println("Array is sorted in $swaps swaps.")
        println("First Element: ${a.first()}")
        print("Last Element: ${a.last()}")
    }

}