package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/contains-duplicate
 * Progress: Done
 */
object ContainsDuplicate {
    /**
     * Try to add the items to a set. If any addition returns false, we know there is a duplicate
     */
    fun containsDuplicate(nums: IntArray): Boolean {
        var set = mutableSetOf<Int>()
        for (num in nums) {
            if (!set.add(num)) return true
        }
        return false
    }
}