package practice

fun main() {
    var line = readLine()
    var arr = line!!.split(" ")
    arr = arr.sorted()

    var answer = ""

    for (i in 0 until arr.size-1) {
        answer += "${arr[3].toInt() - arr[i].toInt()} "
    }

    println(answer)
}