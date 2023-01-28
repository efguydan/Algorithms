package practice

object MiscKt {

    @JvmStatic
    fun main(args: Array<String>) {
        println(firstMissingPositive(intArrayOf(3,4,-1,1)))
        println(firstMissingPositive(intArrayOf(1,2,0)))
        println(firstMissingPositive(intArrayOf(7,8,9,11,12)))
        println(firstMissingPositive(intArrayOf(2,1)))
//        println(firstMissingPositive(intArrayOf(10,4,16,54,17,-7,21,15,25,31,61,1,6,12,21,46,16,56,54,12,23,20,38,63,2,27,35,11,13,47,13,11,61,39,0,14,42,8,16,54,50,12,-10,43,11,-1,24,38,-10,13,60,0,44,11,50,33,48,20,31,-4,2,54,-6,51,6)))
    }

    fun firstMissingPositive(nums: IntArray): Int {
        for (index in nums.indices) {
            if (nums[index] > 0 && nums[index] - 1 <= nums.lastIndex) {
                recurse(nums, nums[index] - 1, index)
            }
        }
        println(nums.contentToString())
        for (i in nums.indices) if (nums[i] != i + 1) return i + 1
        return nums.size + 1
    }

    private fun recurse(nums: IntArray, index: Int, baseIndex: Int) {
        if (index == baseIndex) nums[index] = index + 1
        if (index > nums.lastIndex || index < 0 || index + 1 == nums[index]) return
        recurse(nums, nums[index] - 1, baseIndex)
        nums[index] = index + 1
    }
}
