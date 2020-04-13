package practice

fun main() {
    val sample = "OOTimiBoladeEE"
    val arr = sample.split("TimiBolade".reversed().toRegex()).joinToString(separator = "")
    println(arr)
}