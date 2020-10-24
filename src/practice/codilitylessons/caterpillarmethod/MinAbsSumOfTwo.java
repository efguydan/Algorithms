package practice.codilitylessons.caterpillarmethod;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/15-caterpillar_method/min_abs_sum_of_two/
 * Codility Report Link: https://app.codility.com/demo/results/trainingNHPWZB-R6N/
 * Progress: Done
 */
public class MinAbsSumOfTwo {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 4, -3}));
        System.out.println(solution(new int[] {-8, 4, 5, -10, 3}));
    }

    public static int solution(int[] a) {
        int answer = Integer.MAX_VALUE;
        Arrays.sort(a);
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int temp = a[left] + a[right];
            answer = Math.min(answer, Math.abs(temp));

            if (temp <= 0) left++; else right--;
        }
        return answer;
    }

}
