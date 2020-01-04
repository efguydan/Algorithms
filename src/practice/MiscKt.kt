package practice

fun main() {
    print("Enter Person's Year of Birth: ")
    var person: Int = readLine()?.toInt() ?: 0
    print("Enter Mother's Year of Birth: ")
    var mother = readLine()?.toInt() ?: 0

    person = 2019 - person
    mother = 2019 - mother

    for (i in 0..6) {

        println("$mother:$person")
        person += 7
        mother += 7
    }
}