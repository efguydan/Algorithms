package practice.projecteuler

/**
 * @author EfeDaniel
 * Link: https://projecteuler.net/problem=1
 * Progress: Done
 */
object MultiplesOf3And5 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(multiplesOfThreeAndFive(10))
        println(multiplesOfThreeAndFive(1000))
    }

    fun multiplesOfThreeAndFive(n: Int): Int {
        var sum = 0
        for (i in 0 until n step 3) sum += i
        for (i in 0 until n step 5) sum += i
        for (i in 0 until n step 15) sum -= i
        return sum
    }

}