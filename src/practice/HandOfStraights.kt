package practice

/**
 *  @author EfeDaniel
 * Link: https://leetcode.com/problems/hand-of-straights/
 * Progress: Done
 */
object HandOfStraights {

    @JvmStatic
    fun main(args: Array<String>) {
        println(isNStraightHand(intArrayOf(1,2,3,6,2,3,4,7,8), 3))
        println(isNStraightHand(intArrayOf(1,2,3,4,5), 4))
        println(isNStraightHand(intArrayOf(0,1), 2))
    }

    private fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        val list = listOf<Any>()
        if (hand.size % groupSize != 0) return false
        hand.sort()

        val map = mutableMapOf<Int, Int>()
        for (number in hand) map[number] = (map[number] ?: 0) + 1

        while(map.isNotEmpty()) {
            val lowestKey = map.keys.first()
            for(i in lowestKey until lowestKey + groupSize) {
                when(val current = map[i] ?: 0) {
                    0 -> return false
                    1 -> map.remove(i)
                    else -> map[i] = current - 1
                }
            }
        }

        return true
    }

}