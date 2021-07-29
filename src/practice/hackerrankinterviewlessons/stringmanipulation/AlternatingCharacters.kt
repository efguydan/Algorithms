package practice.hackerrankinterviewlessons.stringmanipulation

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/alternating-characters
 * Progress: Done
 */
object AlternatingCharacters {

    @JvmStatic
    fun main(args: Array<String>) {
        println(alternatingCharacters("AABAAB"))
        println(alternatingCharacters("AAAA"))
        println(alternatingCharacters("BBBBB"))
        println(alternatingCharacters("ABABABAB"))
        println(alternatingCharacters("BABABA"))
        println(alternatingCharacters("AAABBB"))
    }

    fun alternatingCharacters(s: String): Int {
        var answer = 0
        val chars = s.toCharArray()
        if (chars.isEmpty()) return answer

        var previous = chars.first()
        (1 until chars.size).map { chars[it] }.forEach {
            if (it == previous) answer++
            else previous = it
        }

        return answer
    }

}