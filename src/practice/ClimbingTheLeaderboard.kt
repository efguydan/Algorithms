package practice

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 * Progress: Done
 */
object ClimbingTheLeaderboard {

    @JvmStatic
    fun main(args: Array<String>) {
        println(climbingLeaderboard(arrayOf(100, 90, 90, 80), arrayOf(70, 80, 105)).contentToString())
    }

    fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
        val answer = Array(player.size) { 0 }

        var lastCompared = ranked.first()
        var temp = true
        var currentRank = 0
        val ranks = Array(ranked.size) {
            if (temp || ranked[it] < lastCompared) {
                currentRank++
                lastCompared = ranked[it]
                temp = false
            }
            currentRank
        }

        var currentIndex = ranks.lastIndex
        player.forEachIndexed { index, score ->
            while (ranked[currentIndex] < score && currentIndex > 0) currentIndex--

            if (score < ranked[currentIndex]) answer[index] = ranks[currentIndex] + 1
            else answer[index] = ranks[currentIndex]
        }

        return answer
    }

}