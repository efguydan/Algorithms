package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/valid-anagram/
 * Progress: Done
 */
object ValidAnagram {

    /**
     * Main method Used mainly for testing purposes. Tests the input case:
     * s = "anagram", t = "nagaram", output = true
     * s= "a", t = "b", output = false
     */
    @JvmStatic
    fun main(args: Array<String>) {
        println(isAnagram("anagram", "nagaram"))
        println(isAnagram("a", "b"))
    }

    /**
     * Solution Method. Sorts both strings and compares them with each other. If they are the same, they are anagrams
     * and true is returned, else, they arent and false is returned.
     *
     * Bubble Sort isn't used for sorting because it times out for a input case
     */
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        return s.sort() == t.sort()
    }

    /**
     * Method helper for sorting a string using bubble sort algorithm
     */
    fun bubbleSort(string: String): String {
        if (string.length < 2) return string
        val arr = string.toCharArray()
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

    /**
     * String sort helper method using the inbuilt algorithm
     */
    private fun String.sort() = String(toCharArray().apply { sort() })

}