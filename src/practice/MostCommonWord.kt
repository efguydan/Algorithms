package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/most-common-word/
 * Progress: Done
 */
object MostCommonWord {

    @JvmStatic
    fun main(args: Array<String>) {
        println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit")))
        println(mostCommonWord("Bob. hIt, baLl", arrayOf("bob", "hit")))
    }

    private fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        var max = -1
        var answer = ""
        val wordArr = Regex("[^A-Za-z ]").replace(paragraph, " ").split(" ").map { it.toLowerCase() }
        val map = mutableMapOf<String, Int>()
        for (word in banned) map[word.toLowerCase()] = -1

        for (word in wordArr) {
            if (map[word] == -1 || word.isEmpty()) continue
            map[word] = ((map[word] ?: 0) + 1).also {
                if (it > max) {
                    max = it
                    answer = word
                }
            }
        }
        return answer
    }

}