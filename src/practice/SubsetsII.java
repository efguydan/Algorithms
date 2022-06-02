package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/subsets-ii/
 * Progress: Done
 */
public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    static HashSet<Integer> unique = new HashSet<>();
    static List<List<Integer>> answers = new ArrayList<>();
    static int[] numbers;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        unique.clear();
        answers.clear();
        numbers = nums;

        Arrays.sort(nums);
        addToAnswer(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            recurse(new ArrayList<>(), i);
        }

        return answers;
    }

    public static void recurse(List<Integer> set, int nextIndex) {
        if (nextIndex > numbers.length) return;
        set.add(numbers[nextIndex]);
        addToAnswer(set);

        for (int i = nextIndex+1; i < numbers.length; i++) {
            recurse(new ArrayList<>(set), i);
        }

    }

    public static void addToAnswer(List<Integer> set) {
        int hash = set.hashCode();
        if (!unique.contains(hash)) {
            unique.add(hash);
            answers.add(new ArrayList<>(set));
        }
    }
}
