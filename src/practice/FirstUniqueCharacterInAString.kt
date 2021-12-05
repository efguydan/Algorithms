package practice

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/bigger-is-greater/problem
 * Progress: Done
 */

object FirstUniqueCharacterInAString {

    @JvmStatic
    fun main(args: Array<String>) {
        println(firstUniqChar("efe"))
    }

    fun firstUniqChar(s: String): Int {
        var map = mutableMapOf<Char, Int>()
        var characters = s.toCharArray()

        characters.forEachIndexed { index, c ->
            map[c] = if (map.containsKey(c)) -1 else index
        }

        return map.values.firstOrNull { it != -1 } ?: -1
    }

}