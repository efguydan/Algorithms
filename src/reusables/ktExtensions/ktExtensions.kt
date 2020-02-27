package reusables.ktExtensions

import java.util.*

fun readString() = readLine()!!

fun readLong() = readString().toLong()

fun readLongArray(size: Long): Array<Long> {
    var larr = readLine()!!.split(" ")
    return Array(size.toInt()) { i -> larr[i].toLong() }
}

fun MutableList<String>.print() = this.forEach { println(it) }