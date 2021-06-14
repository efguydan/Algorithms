package practice.hackerrankinterviewlessons.dictionariesandhashmaps

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/count-triplets-1/problem
 * Progress: Done
 */
object CountTriplets {

    @JvmStatic
    fun main(args: Array<String>) {
        println(countTriplets(arrayOf(1, 4, 16, 64), 4))
        println(countTriplets(arrayOf(1, 5, 5, 25, 125), 5))
        println(countTriplets(arrayOf(1, 3, 9, 9, 27, 81), 3))
        print(countTriplets(arrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1 ,1), 1))
    }

    fun countTriplets(arr: Array<Long>, r: Long): Long {
        var triplets = 0L
        if (arr.size < 3) return triplets

        val valuesCount = mutableMapOf<Long, Long>()
        val potentialTriplets = mutableMapOf<Long, Long>()

        for (i in arr.lastIndex downTo 0) {
            val t1 = arr[i]
            val t2 = t1*r
            val t3 = t2*r

            triplets += potentialTriplets[t3] ?: 0

            potentialTriplets[t2] = (potentialTriplets[t2] ?: 0L) + (valuesCount[t2] ?: 0L)

            valuesCount[t1] = (valuesCount[t1] ?: 0L) + 1

        }

        return triplets
    }

}