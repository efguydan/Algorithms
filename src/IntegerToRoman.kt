import java.lang.StringBuilder

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/integer-to-roman
 * Progress: Done
 */

fun main(args : Array<String>) {
    println("3 : " + intToRoman(3))
    println("4 : " + intToRoman(4))
    println("9 : " + intToRoman(9))
    println("58 : " + intToRoman(58))
    println("1994 : " + intToRoman(1994))
}

fun intToRoman(num: Int): String {
    var number = num;
    var answer = StringBuilder()
    var nextPossibleRoman : Int;
    while (number > 0) {
        nextPossibleRoman = getNextPossibleRoman(number);
        answer.append(getRomanFromNumber(nextPossibleRoman))
        number -= nextPossibleRoman;
    }
    return answer.toString();
}

fun getNextPossibleRoman(num: Int): Int {
    var array : Array<Int> = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    for (number in array) {
        if (num >= number)
            return number
    }
    return 0;
}

fun getRomanFromNumber(num : Int) : String {
    return when(num) {
        1 -> "I"
        4 -> "IV"
        5 -> "V"
        9 -> "IX"
        10 -> "X"
        40 -> "XL"
        50 -> "L"
        90 -> "XC"
        100 -> "C"
        400 -> "CD"
        500 -> "D"
        900 -> "CM"
        else -> "M"
    }
}