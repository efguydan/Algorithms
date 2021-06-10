package practice.hackerrankinterviewlessons.arrays

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/new-year-chaos/problem
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Progress: Done
 */
object NewYearChaos {

    /**
     * Main method main used for testing purposes
     * Tests multiple input cases
     *
     */
    @JvmStatic
    fun main(args: Array<String>) {
        minimumBribes(arrayOf(2, 1, 5, 3, 4))
        minimumBribes(arrayOf(2, 5, 1, 3, 4))
        minimumBribes(arrayOf(4, 1, 2, 3))
        minimumBribes(arrayOf(1, 2, 5, 3, 7, 8, 6, 4))
    }

    private const val TOO_CHAOTIC = "Too chaotic"

    /**
     * Solution method. The basic idea is to go through each person on the queue, and try to figure out how many people
     * they collected bribes from.
     */
    fun minimumBribes(q: Array<Int>) {
        var bribes = 0

        for (i in q.indices) {
            var position = i+1
            var person = q[i]

            if (person - position > 2) {
                println(TOO_CHAOTIC)
                return
            }

            var startIndex = (person - 2).coerceAtLeast(0)
            for (j in startIndex..i) {
                if (q[j] > person) bribes++
            }
        }

        println(bribes)
    }

}