package practice

fun main() {
    println(isValid("()[]{}"))
    println(isValid("()[]{}{"))
    println(isValid("((()))"))
}

fun isValid(s: String): Boolean {
    var t = s
    var prevLength = t.length
    while(t.isNotEmpty()) {
        t = t.replace("\\[\\]|\\(\\)|\\{\\}".toRegex(), "")
        if (prevLength == t.length) return false else prevLength = t.length
    }
    return true
}