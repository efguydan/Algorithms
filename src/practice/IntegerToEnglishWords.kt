package practice

import kotlin.math.pow

/**
 *  @author EfeDaniel
 * Link: https://leetcode.com/problems/integer-to-english-words/
 * Progress: Done
 */

val thousand: Double = 1000.0
val numberList = listOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
val tensList = listOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
val lionList = listOf("", "Thousand", "Million", "Billion")


fun main() {
    println(numberToWords(1234))
    println(numberToWords(999))
    println(numberToWords(56788291))
    println(numberToWords(0))
    println(numberToWords(1001))
}

fun numberToWords(num: Int): String {
    if (num == 0) return "zero"
    return dps(num, num.toString().length / 3).replace("\\s+".toRegex(), " ").trim()
}

fun dps(num: Int, level: Int): String {
    if (level < 0) return ""
    var rem = num / thousand.pow(level).toInt()
    if (rem == 0) return "" + dps(num, level-1)

    var a = ""
    a = if (rem / 100 > 0) "$a${numberList[rem/100]} hundred" else a
    rem %= 100
    a = if (rem > 19) "$a ${tensList[rem/10]} ${numberList[(rem%10)]}" else "$a ${numberList[rem]}"
    a = "$a ${lionList[level]}"
    return a + " " + dps(num % thousand.pow(level).toInt(), level - 1)
}