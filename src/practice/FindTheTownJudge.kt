package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/find-the-town-judge/
 * Progress: Done
 */
object FindTheTownJudge {

    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val trustMap = mutableMapOf<Int, MutableSet<Int>>()
        for (singleTrust in trust) {
            trustMap[singleTrust[0]] = (trustMap[singleTrust[0]] ?: mutableSetOf()).also { it.add(singleTrust[1]) }
        }

        for (i in 1..n) {
            if (!trustMap[i].isNullOrEmpty()) continue
            var potentialJudge = true
            for (j in 1..n ) {
                if (j == i) continue
                potentialJudge = potentialJudge && trustMap[j]?.contains(i) ?: false
            }
            if (potentialJudge) return i
        }

        return -1
    }

}