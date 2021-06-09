package practice.hackerrankinterviewlessons.arrays

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 * Progress: Done
 */
object LeftRotation {

    @JvmStatic
    fun main(args: Array<String>) {
        println(rotLeft(arrayOf(1,2,3,4,5), 4).contentToString())
    }

    fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
        if (d == 0 || d % a.size == 0) return a

        return Array(a.size) { a[(it + d) % a.size] }
    }

}