package practice.codewars

/**
 * @author EfeDaniel
 * Link: https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1
 * Progress: Done
 */

object CountDuplicates {
    fun duplicateCount(text: String): Int {
        var set = mutableSetOf<Char>()
        var duplicates = mutableSetOf<Char>()

        with(text.toLowerCase().toCharArray()) {
            for (char in this) {
                if (!set.add(char)) duplicates.add(char)
            }
        }

        return duplicates.size
    }
}