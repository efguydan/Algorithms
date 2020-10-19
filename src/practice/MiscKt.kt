package practice

import java.util.*
import kotlin.math.roundToInt

fun main() {
    val input = Scanner(System.`in`)
    val n = input.nextInt()

    var answer = 0;

    for (i in 2..n step 2) {
        answer += i;
    }

    println(answer)
}
