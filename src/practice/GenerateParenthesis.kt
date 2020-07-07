package practice

/**
 *  @author EfeDaniel
 * Link: https://leetcode.com/problems/generate-parentheses
 * Progress: Done
 */
fun main() {
    for (parenthesis in generateParenthesis(3)) println(parenthesis)
}

fun generateParenthesis(n: Int): List<String> {
    val answerList = mutableListOf<String>()
    fillWithParenthesis(answerList, "", n, n)
    return answerList
}

fun fillWithParenthesis(answerList: MutableList<String>, currentBrackets: String, left: Int, right: Int) {
    if (left>right) return
    if (left == 0 && right == 0) {
        answerList.add(currentBrackets)
        return
    }
    if (left > 0) fillWithParenthesis(answerList, "$currentBrackets(", left - 1, right)
    if (right > 0) fillWithParenthesis(answerList, "$currentBrackets)", left, right - 1)
}