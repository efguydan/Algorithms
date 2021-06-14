package practice.hackerrankinterviewlessons.dictionariesandhashmaps

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 * Progress: Done
 */
object SherlockAndAnagrams {

    @JvmStatic
    fun main(args: Array<String>) {
        println(sherlockAndAnagrams("abba"))
    }

    fun sherlockAndAnagrams(s: String): Int {
        val arr = s.toCharArray()
        var answer = 0
        val map = mutableMapOf<String, Int>()
        val combinationsMap = mutableMapOf<Int, Int>()
        combinationsMap[1] = 0

        for (i in 1 until s.length) {
            map.clear()
            for (j in 0 .. arr.size-i) {
                val str = arr.subsetToString(j, i).sort()
                map[str] = (map[str] ?: 0) + 1
            }

            for (count in map.values) {
                if (combinationsMap.containsKey(count)) {
                    answer += combinationsMap[count] ?: 0
                } else {
                    val combination = combination(count)
                    answer += combination
                    combinationsMap[count] = combination
                }
            }
        }

        return answer
    }

    private fun CharArray.subsetToString(startIndex: Int, count: Int): String {
        return String(this, startIndex, count)
    }

    private fun String.sort() = String(toCharArray().apply { sort() })

    private fun combination(n: Int, rVal: Int = 2): Int {
        var r = rVal
        if (r > n / 2) r = n - r
        var numerator = 1L
        var denominator = 1L
        for (i in 1..r) {
            numerator *= (n - i + 1).toLong()
            denominator *= i.toLong()
        }
        return (numerator / denominator).toInt()
    }

}