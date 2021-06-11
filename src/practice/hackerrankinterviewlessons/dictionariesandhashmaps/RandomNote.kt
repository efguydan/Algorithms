package practice.hackerrankinterviewlessons.dictionariesandhashmaps

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Progress: Done
 */
object RandomNote {

    /**
     * Solution method. Calls a helper method that actually solves the problem.
     */
    fun checkMagazine(magazine: Array<String>, note: Array<String>) {
        println(isNotePossible(magazine, note))
    }

    /**
     * Solution method. Stores the available words in a map and tries to see if they are
     * enough to recreate the required word. Returns Yes or No depending on the scenario.
     */
    private fun isNotePossible(magazine: Array<String>, note: Array<String>): String {
        val map = mutableMapOf<String, Int>()
        for (word in magazine) map[word] = (map[word] ?: 0) + 1

        for (word in note) {
            val amountOfWords = map[word] ?: return "No"
            if (amountOfWords <= 0) return "No"
            map[word] = amountOfWords - 1
        }

        return "Yes"
    }

}