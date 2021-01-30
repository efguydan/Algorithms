package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/valid-anagram/
 * Progress: Done
 */
object ValidAnagram {

    @JvmStatic
    fun main(args: Array<String>) {
        println(isAnagram("anagram", "nagaram"))
        println(isAnagram("a", "b"))
    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        return s.sort() == t.sort()
    }

    fun bubbleSort(string: String): String {
        if (string.length < 2) return string
        var arr = string.toCharArray()
        var swapped = true
        while (swapped) {
            swapped = false
            for (i in 1..string.lastIndex) {
                if (arr[i] < arr[i-1]) {
                    arr[i] = arr[i-1].also { arr[i-1] = arr[i] }
                    swapped = true
                }
            }
        }
        return arr.joinToString(separator = "")
    }

    private fun String.sort() = String(toCharArray().apply { sort() })

}