package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/longest-common-prefix
 * Progress: Done
 */

fun main(args: Array<String>) {
    var answer = longestCommonPrefix(arrayOf("flower", "flow", "flight"))
    println("$answer " + answer.equals("fl"))
    answer = longestCommonPrefix(arrayOf("dog", "racecar", "car"))
    println("$answer " + answer.equals(""))
    answer = longestCommonPrefix(arrayOf("aa", "a"))
    println("$answer " + answer.equals("a"))
}

fun longestCommonPrefix(strs: Array<String>): String {
    var answer: StringBuilder = StringBuilder()
    try {
        answer.append(strs[0])
    } catch (error: ArrayIndexOutOfBoundsException) {
        return ""
    }

    for (string in strs) {
        if (answer.toString().equals(string))
            continue
        var index = 0
        for (char in answer) {
            try {
                if (char != string[index]) {
                    answer.delete(index, answer.length)
                    break
                }
            } catch (error: StringIndexOutOfBoundsException) {
                answer.delete(index, answer.length)
                break;
            }
            index++
        }
    }
    return answer.toString()
}