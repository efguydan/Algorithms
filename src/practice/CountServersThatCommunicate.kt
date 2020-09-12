package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/count-servers-that-communicate
 * Progress: Done
 */
object CountServersThatCommunicate {

    @JvmStatic
    fun main(args: Array<String>) {
        println(countServers(arrayOf(intArrayOf(1, 0), intArrayOf(1, 1))))
        println(countServers(arrayOf(intArrayOf(1,1,0,0), intArrayOf(0,0,1,0), intArrayOf(0,0,1,0), intArrayOf(0,0,0,1))))
    }

    fun countServers(grid: Array<IntArray>): Int {
        val found = mutableSetOf<String>()
        for (i in grid.indices) {
            var foundOnRow = false
            var foundIndex = -1
            for (j in grid[i].indices) {
                if (!grid[i][j].isServer()) continue
                if (foundOnRow) {
                    found.add("$i-$j")
                    found.add("$i-$foundIndex")
                } else {
                    foundOnRow = true
                    foundIndex = j
                }
            }
        }

        for (j in grid[0].indices) {
            var foundOnCol = false
            var foundIndex = -1
            for (i in grid.indices) {
                if (!grid[i][j].isServer()) continue
                if (foundOnCol) {
                    found.add("$i-$j")
                    found.add("$foundIndex-$j")
                } else {
                    foundOnCol = true
                    foundIndex = i
                }
            }
        }
        return found.size
    }

    private fun Int.isServer() = this == 1

}