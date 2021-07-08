package practice.hackerrankinterviewlessons.stringmanipulation

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 * Progress: Done
 */
object StringsMakingAnagrams {

    fun makeAnagram(a: String, b: String): Int {
        var answer = 0
        val map = mutableMapOf<Char, Int>()
        for (c in a) map[c] = (map[c] ?: 0) + 1
        for (c in b) map[c] = (map[c] ?: 0) - 1

        for (count in map.values) answer += count.neutralValue()
        return answer
    }

    private fun Int.neutralValue(): Int = if (this < 0) this * -1 else this

}