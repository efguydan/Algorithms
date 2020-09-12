package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/plus-one/
 * Progress: Done
 */
object PlusOne {

    @JvmStatic
    fun main(args: Array<String>) {
        println(plusOne(intArrayOf(4, 3, 2, 1)).contentToString())
    }

    fun plusOne(digits: IntArray): IntArray {
        val digitList = digits.toMutableList()
        loop@ for (i in digitList.size-1 downTo 0) {
            digitList[i] = if (digitList[i] == 9) 0 else ++digits[i]
            when {
                i == 0 && digitList[i] == 0 -> digitList.add(0, 1)
                digitList[i] != 0 -> break@loop
            }
        }
        return digitList.toIntArray()
    }

}