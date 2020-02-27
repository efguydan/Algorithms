package practice.codeforces

fun main() {
    val T = readLine()!!.toInt()
    for (i in 0 until T) {
        val num = readLine()!!.toLong()
        val answer = if (num > 1000000) {
            var toTop = if (num % 1000000 >= 500000) 1 else 0
            (num / 1000000 + toTop).toString() + "M"
        } else if (num >= 999500) {
            "1M"
        } else if (num > 999) {
            var toTop = if (num % 1000 >= 500) 1 else 0
            (num / 1000 + toTop).toString() + "K"
        } else {
            num.toString()
        }
        println(answer)
    }
}