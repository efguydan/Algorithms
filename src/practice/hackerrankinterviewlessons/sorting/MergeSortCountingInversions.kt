package practice.hackerrankinterviewlessons.sorting

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/ctci-merge-sort/problem
 * Progress: Done
 */
object MergeSortCountingInversions {

    @JvmStatic
    fun main(args: Array<String>) {
        println(countInversions(arrayOf(1,5,3,7)))
        println(countInversions(arrayOf(7,5,3,1)))
    }

    fun countInversions(arr: Array<Int>): Long {
        return countInversions(arr, 0, arr.lastIndex, arr.clone())
    }

    private fun countInversions(arr: Array<Int>, low: Int, high: Int, aux: Array<Int>): Long {
        if (low >= high) return 0

        val mid = (high + low) / 2
        var count = 0L
        count += countInversions(aux, low, mid, arr)
        count += countInversions(aux, mid + 1, high, arr)
        count += merge(arr, low, mid, high, aux)

        return count
    }

    private fun merge(arr: Array<Int>, low: Int, mid: Int, high: Int, aux: Array<Int>): Long {
        var count = 0L
        var i = low
        var j = mid+1
        var k = low

        while (i <= mid || j <= high) {
            when {
                i > mid -> arr[k++] = aux[j++]
                j > high -> arr[k++] = aux[i++]
                aux[i] <= aux[j] -> arr[k++] = aux[i++]
                else -> {
                    arr[k++] = aux[j++]
                    count += mid + 1 - i
                }
            }
        }

        return count
    }

}