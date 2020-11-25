package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/string-matching-in-an-array/
 * Progress: Done
 */
object StringMatchingInAnArray {

    @JvmStatic
    fun main(args: Array<String>) {
        println(stringMatching(arrayOf("mass","as","hero","superhero","zo")))
    }

    private fun stringMatching(words: Array<String>): List<String> {
        val answer = mutableListOf<String>()
        val sortedWords = words.sortedBy { it.length }
        for (i in 0 until sortedWords.lastIndex) {
            for (j in i+1..sortedWords.lastIndex) {
                if (isSubstring(sortedWords[i], sortedWords[j])) {
                    answer.add(sortedWords[i])
                    break
                }
            }
        }
        return answer
    }

    private fun isSubstring(target: String, word: String): Boolean {
        val targetChar = target.toCharArray()
        val wordChar = word.toCharArray()
        for (i in wordChar.indices) {
            if (wordChar.size - i < targetChar.size) return false
            for (j in targetChar.indices) {
                if (wordChar[i+j] != targetChar[j]) break
                if (j == targetChar.lastIndex) return true
            }
        }
        return false
    }

}