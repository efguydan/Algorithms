package practice.codeforces

fun main() {
    var arr = readLongArray(4)
    arr.sort()
    var answer = ""

    answer += arr[3] - arr[0]
    answer += " "
    answer += arr[3] - arr[1]
    answer += " "
    answer += arr[3] - arr[2]

    println(answer)
}

fun readLongArray(size: Long): Array<Long> {
    var larr = readLine()!!.split(" ")
    return Array(size.toInt()) { i -> larr[i].toLong() }
}