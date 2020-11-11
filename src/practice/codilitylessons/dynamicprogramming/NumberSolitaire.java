package practice.codilitylessons.dynamicprogramming;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/
 * Codility Report Link: https://app.codility.com/demo/results/trainingFTJDTU-Y8T/
 * Progress: Done
 */
public class NumberSolitaire {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,-2,0,9,-1,-2}));
    }

    public static int solution(int[] a) {
        int[] dp = new int[a.length];
        dp[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            int max = Integer.MIN_VALUE;

            for(int die = 1; die <= 6; die++) {
                if (i-die < 0) break;
                max = Math.max(dp[i-die]+a[i], max);
            }
            dp[i] = max;
        }

        return dp[dp.length-1];
    }

}
