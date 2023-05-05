package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/shift-2d-grid/
 * Time Complexity: O(MN)
 * Space Complexity: O(MN)
 * Progress: Done
 */
object Shift2DGrid {

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            shiftGrid(
                grid = arrayOf(
                    intArrayOf(1,2,3),
                    intArrayOf(4,5,6),
                    intArrayOf(7,8,9),
                ),
                k = 2,
            ).toString()
        )
    }

    private fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val numRows = grid.size
        val numColumns = grid.first().size

        val gridSize = numRows * numColumns
        val realK = k % gridSize
        val answer = Array(numRows) { IntArray(numColumns) { 0 } }

        for (i in 0 until gridSize) {
            val currentRow = i / numColumns
            val currentColumn = i % numColumns

            val newRow = ((i+realK) % gridSize) / numColumns
            val newColumn = ((i+realK) % gridSize) % numColumns

            answer[newRow][newColumn] = grid[currentRow][currentColumn]
        }

        return answer.toList().map(IntArray::toList)
    }
}