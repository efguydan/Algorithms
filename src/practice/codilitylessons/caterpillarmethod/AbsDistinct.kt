package practice.codilitylessons.caterpillarmethod

import kotlin.math.abs

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/15-caterpillar_method/abs_distinct/
 * Codility Report Link: https://app.codility.com/demo/results/training9BTVHR-3U8/
 * Progress: Done
 */
object AbsDistinct {
    fun solution(a: IntArray) = with(HashSet<Int>()) {
        for (num in a) add(abs(num))
        size
    }
}