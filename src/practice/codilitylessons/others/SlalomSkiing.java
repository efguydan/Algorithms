package practice.codilitylessons.others;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/90-tasks_from_indeed_prime_2015_challenge/slalom_skiing/
 * Codility Report Link: https://app.codility.com/demo/results/training3UCMN2-BXE/
 * Progress: Done
 */
public class SlalomSkiing {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {15, 13, 5, 7, 4, 10, 12, 8, 2, 11, 6, 9, 3}));
    }

    public static int solution(int[] a) {
        long bound = getMax(a);
        long[] withMirrors = new long[a.length * 3];

        for (int i = 0; i < a.length; i++) {
            withMirrors[i*3] = bound * 2 + a[i] + 1;
            withMirrors[i*3 + 1] = bound * 2 - a[i] + 1;
            withMirrors[i*3 + 2] = a[i];
        }

        return lengthOfLIS(withMirrors);
    }

    private static int lengthOfLIS(long[] nums) {
        long[] temp = new long[nums.length];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int fnd = Arrays.binarySearch(temp, 0, idx, nums[i]);
            if (fnd < 0) fnd = -fnd - 1;
            if (fnd == idx) idx++;
            temp[fnd] = nums[i];
        }
        return idx;
    }

    private static int getMax(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int num: a) max = Math.max(max, num);
        return max;
    }

}
