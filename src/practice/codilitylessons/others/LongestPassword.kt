package practice.codilitylessons.others

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/90-tasks_from_indeed_prime_2015_challenge/longest_password/
 * Codility Report Link: https://app.codility.com/demo/results/trainingEVTRS9-SBP/
 * Progress: Done
 */
object LongestPassword {
    @JvmStatic
    fun main(args: Array<String>) {
        println(solution("zaq123edc33ee33ee"))
    }

    fun solution(s: String): Int {
        var passwords = s.split(" ")
        passwords = passwords.sortedBy { it.length }
        for (password in passwords.reversed()) if (password.isValid()) return password.length
        return -1
    }

    fun String.isValid(): Boolean {
        val charArray = this.toCharArray()
        var letterCount = 0
        var digitCount = 0
        for (char in charArray) {
            when {
                char.isDigit() -> digitCount++
                char.isLetter() -> letterCount++
                else -> return false
            }
        }
        if (!letterCount.isEven()) return false
        if (digitCount.isEven()) return false
        return true
    }

    fun Int.isEven(): Boolean = this % 2 == 0

    // 90% score >>

    private fun String.isValidPassword(): Boolean {
        if (this.length % 2 == 0) return false
        if (!this.matches("^[a-zA-Z0-9]+\$".toRegex())) return false
        if (getNumericalContent().length % 2 == 0) return false
        if (getNonNumericalContent().length % 2 != 0) return false
        return true
    }

    private fun String.getNumericalContent() = Regex("\\d+").find(this)?.groupValues?.joinToString(separator = "") ?: ""

    private fun String.getNonNumericalContent() = Regex("^[a-zA-Z]+\$").find(this)?.groupValues?.joinToString(separator = "") ?: ""

}