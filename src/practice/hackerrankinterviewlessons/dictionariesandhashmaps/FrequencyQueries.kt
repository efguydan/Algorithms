package practice.hackerrankinterviewlessons.dictionariesandhashmaps

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/frequency-queries/problem
 * Progress: Done
 */
object FrequencyQueries {

    fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
        val queriesResults = mutableListOf<Int>()

        val valuesMap = mutableMapOf<Int, Int>()
        val countsMap = mutableMapOf<Int, Int>()
        for (query in queries) {
            when (query[0]) {
                1 -> {
                    val currentCount = valuesMap[query[1]] ?: 0
                    if (currentCount != 0) countsMap[currentCount] = countsMap[currentCount]!! - 1

                    valuesMap[query[1]] = currentCount + 1
                    countsMap[currentCount+1] = (countsMap[currentCount+1] ?: 0) + 1
                }
                2 -> {
                    var currentCount = valuesMap[query[1]] ?: 0

                    if (currentCount > 0) {
                        valuesMap[query[1]] = currentCount - 1
                        countsMap[currentCount] = (countsMap[currentCount] ?: 1) - 1
                        valuesMap[query[1]] = currentCount - 1
                        countsMap[currentCount-1] = (countsMap[currentCount-1] ?: 0) + 1
                    }
                }
                3 -> {
                    val count = countsMap[query[1]] ?: 0
                    queriesResults.add(if (count > 0) 1 else 0)
                }
            }
        }

        return queriesResults.toTypedArray()
    }

}