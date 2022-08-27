package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/group-anagrams/
 * Concepts: Array & Hashing
 * Progress: Done
 */
object GroupAnagrams {

    @JvmStatic
    fun main(args: Array<String>) {
        println(groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
    }

    /**
     * The idea is the turn each word into a key that would be the same for all anagrams and store them into a map
     */
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        val answer = mutableListOf<List<String>>()
        for (word in strs) {
            val key = convertWordIntoKey(word)
            val list = map.getOrDefault(key, mutableListOf())
            list.add(word)
            map[key] = list
        }

        return map.values.toList()
    }

    /**
     * Count each character in a word.
     */
    private fun convertWordIntoKey(word: String): String {
        val arr = IntArray(26) { 0 }
        val positionOfA = 'a'.code

        for (character in word) {
            val position = character.code - positionOfA
            arr[position]++
        }
        return arr.joinToString(separator = "-")
    }
}