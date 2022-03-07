package competitions.CodilitySilverChallenge2020

/**
 * @author EfeDaniel
 * Codility Report Link: https://app.codility.com/cert/view/certGW723D-88QP7CSYPYSYBR9J/details/
 * Certificate Link: https://app.codility.com/cert/view/certGW723D-88QP7CSYPYSYBR9J/
 * Progress: Done
 */
object RectangleStrips {

    @JvmStatic
    fun main(args: Array<String>) {
        println(solution(intArrayOf(2,3,2,3,5), intArrayOf(3,4,2,4,2)))
        println(solution(intArrayOf(2,3,1,3), intArrayOf(2,3,1,3)))
        println(solution(intArrayOf(2,10,4,1,4), intArrayOf(4,1,2,2,5)))
    }

    fun solution(a: IntArray, b: IntArray): Int {
        val count = mutableMapOf<Int, Int>()
        for (i in a.indices) {
            count[a[i]] = (count[a[i]] ?: 0) + 1
            if (b[i] != a[i]) count[b[i]] = (count[b[i]] ?: 0) + 1
        }
        return count.values.maxOrNull() ?: 0
    }
}