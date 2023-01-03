package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/3sum/
 * Progress: Done
 */
object ThreeSum {

    @JvmStatic
    fun main(args: Array<String>) {
        println(threeSum(intArrayOf(-1,0,1,2,-1,4)))
        println(threeSum(intArrayOf(34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49)))
    }

    private fun threeSum(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        val sortedNums = nums.sorted()
        for (i in 0..sortedNums.lastIndex-2) {
            if (i > 0 && sortedNums[i] == sortedNums[i-1]) continue
            var start = i + 1
            var end = sortedNums.lastIndex

            while (start < end) {
                val sum = sortedNums[i] + sortedNums[start] + sortedNums[end]
                if (sum == 0) {
                    answer.add(listOf(sortedNums[i], sortedNums[start], sortedNums[end]))
                    while(start < end && sortedNums[start] == sortedNums[start+1]) start++
                    while(end > start && sortedNums[end] == sortedNums[end-1]) end--
                    start++
                    end--
                } else if (sum > 0) {
                    end--
                } else {
                    start++
                }
            }
        }
        return answer
    }
}