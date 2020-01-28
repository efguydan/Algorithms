package practice

class FindKthSmallestPairDistance {

    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        nums.sort()
        var max = 0
        var currentSum = 0
        while(currentSum < k) {
            currentSum += max
            max++
        }
        return 0
    }
}