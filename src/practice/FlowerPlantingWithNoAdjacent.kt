package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/flower-planting-with-no-adjacent/
 * Progress: Done
 */
object FlowerPlantingWithNoAdjacent {

    @JvmStatic
    fun main(args: Array<String>) {
        println(gardenNoAdj(3, arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1))).contentToString())
    }

    private fun gardenNoAdj(n: Int, paths: Array<IntArray>): IntArray {
        val answer = IntArray(n) { -1 }
        val map = mutableMapOf<Int, MutableSet<Int>>()

        for (path in paths) {
            map[path[0]] = (map[path[0]] ?: mutableSetOf()).also { it.add(path[1]) }
            map[path[1]] = (map[path[1]] ?: mutableSetOf()).also { it.add(path[0]) }
        }

        for (i in 1..n) {
            val usedFlowers = (map[i] ?: mutableSetOf()).map { answer[it-1] }.toSet()
            val availableFlowers = mutableSetOf(1, 2, 3, 4).filter { !usedFlowers.contains(it) }
            answer[i-1] = availableFlowers[0]
        }

        return answer
    }

}