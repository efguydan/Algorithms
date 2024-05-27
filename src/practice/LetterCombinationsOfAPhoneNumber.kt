package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * Concepts: Strings
 * Progress: Done
 * Time Complexity: O(2^n)
 * Space Complexity: O(2^n)
 */
object LetterCombinationsOfAPhoneNumber {

    @JvmStatic
    fun main(args: Array<String>) {
        println(letterCombinations("23"))
    }

    private val digitsMap = mapOf(
        '2' to listOf("a", "b", "c"),
        '3' to listOf("d", "e", "f"),
        '4' to listOf("g", "h", "i"),
        '5' to listOf("j", "k", "l"),
        '6' to listOf("m", "n", "o"),
        '7' to listOf("p", "q", "r", "s"),
        '8' to listOf("t", "u", "v"),
        '9' to listOf("w", "x", "y", "z"),
    )

    /**
     * Probably not the best solution but its just recursion.
     * i.e. recursive lopping over each index and then using the map to form the word that can be formed from
     * the chars of that index
     */
    private fun letterCombinations(digits: String): List<String> {
        val result: MutableList<String> = mutableListOf()
        val array: CharArray = digits.toCharArray()

        result.addAll(getCombinations(array, 0, StringBuilder()))

        return result
    }

    private fun getCombinations(array: CharArray, index: Int, current: StringBuilder): List<String> {
        if (index >= array.size) {
            return if (current.isNotEmpty()) listOf(current.toString()) else emptyList()
        }
        val result = mutableListOf<String>()
        val chars = digitsMap[array[index]]

        for (c in chars.orEmpty()) {
            val sb = StringBuilder(current)
            sb.append(c)
            result.addAll(getCombinations(array, index + 1, sb))
        }

        return result
    }
}