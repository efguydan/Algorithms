package practice.codilitylessons.dynamicprogramming;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/17-dynamic_programming/min_abs_sum/
 * Codility Report Link: https://app.codility.com/demo/results/training5YK7PY-3BR/
 * Progress: Done
 */
public class MinAbsSum {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,5,2,-2}));
    }

    public static int solution(int[] a) {
        int max = 0, sum = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.abs(a[i]);
            max = Math.max(max, a[i]);
            sum += a[i];
        }

        int[] count = new int[max + 1];
        for (int num : a) count[num] += 1;

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < max+1; i++) {
            if (count[i] <= 0) continue;
            for (int j = 0; j < sum; j++) {
                if (dp[j] >= 0) dp[j] = count[i];
                else if (j >= i && dp[j-i] > 0) dp[j] = dp[j-i] - 1;
            }
        }

        int answer = sum;

        for (int i = 0; i < sum / 2 + 1; i++) {
            if (dp[i] >= 0) answer = Math.min(answer, sum - 2 * i);
        }

        return answer;
    }

}
