package practice

fun main() {
    println(checkInclusion("ab", "eidbaooo"))
    println(checkInclusion("adc", "dcda"))
}

fun checkInclusion(s1: String, s2: String): Boolean {
    val s1Sorted = s1.sort()
    val s2Array = s2.toCharArray()
    for (i in s2Array.indices) {
        if (s1.contains(s2Array[i])) {
            if ((i + s1.length) <= s2.length && s1Sorted == s2.substring(i, i + s1.length).sort()) return true
        }
    }
    return false
}

fun String.sort() = String(toCharArray().apply { sort() })
