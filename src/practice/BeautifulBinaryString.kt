package practice

object BeautifulBinaryString {

    @JvmStatic
    fun main(args: Array<String>) {
        println(beautifulBinaryString("0101010"))
        println(beautifulBinaryString("01100"))
        println(beautifulBinaryString("010"))
        println(beautifulBinaryString("0100101010"))
    }

    fun beautifulBinaryString(b: String): Int {
        var answer = 0
        var charArray = b.toCharArray()
        for (i in 0..charArray.lastIndex-2) {
            var nextThree = "${charArray[i]}${charArray[i+1]}${charArray[i+2]}"
            if (nextThree == "010") {
                charArray[i+2] = '1'
                answer++
            }
        }
        return answer
    }

}