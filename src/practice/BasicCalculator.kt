package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/basic-calculator/
 * Progress: Done
 */

var i = 0
lateinit var charArray: CharArray

fun main() {
    println(calculate("2+2-(1-2)"))
}

fun calculate(s: String): Int {
    charArray = s.replace("\\s".toRegex(), "").toCharArray()
    return compute()
}

fun compute(): Int {
    var operation = '+'
    var tinyAnswer = 0
    var currentNumber = "0"
    while (i < charArray.size) {
        when {
            charArray[i].isOperation() -> {
                tinyAnswer = performOperation(operation, currentNumber.toInt(), tinyAnswer)
                currentNumber = "0"
                operation = charArray[i]
                i++
            }
            charArray[i] == '(' -> {
                i++
                tinyAnswer = performOperation(operation, compute(), tinyAnswer)
            }
            charArray[i] == ')' -> {
                i++
                tinyAnswer = performOperation(operation, currentNumber.toInt(), tinyAnswer)
                return tinyAnswer
            }
            else -> {
                currentNumber += charArray[i]
                i++
            }
        }
    }
    tinyAnswer = performOperation(operation, currentNumber.toInt(), tinyAnswer)
    return tinyAnswer
}

fun performOperation(operation: Char, operand: Int, currentAnswer: Int): Int {
    return when(operation) {
        '+' -> currentAnswer + operand
        '-' -> currentAnswer - operand
        else -> 0
    }
}

fun Char.isOperation(): Boolean = this == '+' || this == '-'
