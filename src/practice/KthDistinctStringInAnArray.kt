package practice

object KthDistinctStringInAnArray {

    @JvmStatic
    fun main(args: Array<String>) {
        println(kthDistinct(arrayOf("d","b","c","b","c","a"), 2))
        println(kthDistinct(arrayOf("aaa","aa","a"), 1))
        println(kthDistinct(arrayOf("a","b","a"), 3))
    }

    private fun kthDistinct(arr: Array<String>, k: Int): String {
        val map = mutableMapOf<String, Int>()
        for (word in arr) map[word] = map.getOrDefault(word, 0) + 1
        var i = 0
        for (word in arr) {
            if (map[word] == 1 && ++i == k) return word
            map.remove(word)
        }
        return ""
    }
}