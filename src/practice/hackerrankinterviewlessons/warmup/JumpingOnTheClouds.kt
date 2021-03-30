package practice.hackerrankinterviewlessons.warmup

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 * Progress: Done
 */
object JumpingOnTheClouds {

    fun jumpingOnClouds(c: Array<Int>): Int {
        var pos = 0
        var jumps = 0

        while (pos < c.size-1) {
            val maxJump = if (pos + 2 < c.size) 2 else 1
            var chosenJump = 0
            for (i in maxJump downTo 1) {
                if (c[pos + i] == 0) {
                    chosenJump = i
                    break
                }
            }

            pos += chosenJump
            jumps++
        }

        return jumps
    }

}