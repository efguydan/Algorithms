package practice;

/**
 *  @author EfeDaniel
 * Link: https://leetcode.com/problems/find-the-duplicate-number
 * Progress: Done
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] nums1 = {2,5,9,6,9,3,8,9,7,1};
        System.out.println(findDuplicate(nums1));
    }

    public static int findDuplicate(int[] nums) {
        int tortoise, hare = tortoise = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        hare = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

}
