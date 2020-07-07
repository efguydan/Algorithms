package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/first-missing-positive/description/
 * Progress: Done
 */

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums1 = {-1, 1, 3, 4};
        System.out.println(firstMissingPositive2(nums1));

        int[] nums2 = {1, 2};
        System.out.println(firstMissingPositive2(nums2));

        int[] nums3 = {0};
        System.out.println(firstMissingPositive2(nums3));

        int[] nums4 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive2(nums4));

        int[] nums5 = {};
        System.out.println(firstMissingPositive2(nums5));

        int[] nums6 = {1000, -1};
        System.out.println(firstMissingPositive2(nums6));

        int[] nums7 = {0, 2, 2, 1, 1};
        System.out.println(firstMissingPositive2(nums7));

        int[] nums8 = {3, 4, 0, 2};
        System.out.println(firstMissingPositive(nums8));

        int[] nums9 = {-1, 1, 2, 7, 5, 4, 8};
        System.out.println(firstMissingPositive2(nums9));
    }

    public static int firstMissingPositive2(int[] nums) {
        int length = nums.length - 1;
        if (length == -1)
            return 1;

        if (length == 0)
            if (nums[0] == 1)
                return 2;
            else
                return 1;

        List<Integer> positiveList = new ArrayList<>();
        int maxPositive = 0;
        int minPositive = 0;

        boolean minFIrstTime = true;

        //getting positives in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveList.add(nums[i]);
                if (nums[i] > maxPositive) {
                    maxPositive = nums[i];
                    if (minFIrstTime) {
                        minPositive = maxPositive;
                        minFIrstTime = false;
                    }
                }
                if (nums[i] < minPositive && nums[i] > 0)
                    minPositive = nums[i];
            }
        }

        if (minPositive > 1)
            return 1;

        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i < maxPositive; i++)
            list2.add(i);

        list2.removeAll(positiveList);
        if (list2.isEmpty())
            return maxPositive + 1;
        return list2.get(0);

    }

    public static int firstMissingPositive(int[] nums) {
        int length = nums.length - 1;

        if (length == -1)
            return 1;

        if (length == 0)
            if (nums[0] == 1)
                return 2;
            else
                return 1;

        Arrays.sort(nums);
        boolean checkIfIsOne = true;
        if (nums[0] > 1)
            return 1;

        for (int i = 0; i <= nums.length; i++) {
            if (nums[i] < 1 && i != length)
                continue;

            if (checkIfIsOne) {
                if (nums[i] != 1)
                    return 1;
                checkIfIsOne = false;
            }

            if (nums[i] > 0 && i < length) {
                if (nums[i + 1] - nums[i] > 1)
                    return nums[i] + 1;
            }

            if (i == length) {
                if (nums[i] > i + 1)
                    return 1;
                return nums[i] + 1;
            }


        }
        return 1;
    }
}
