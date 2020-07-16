package practice.codilitylessons.timecomplexity;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 * Progress: Not Done
 */
public class PermMissingElement {

    public int solution(int[] a) {
        Arrays.sort(a);
        for (int i = 1; i <= a.length; i++) {
            if (a[i-1] != i) return i;
        }
        return a.length + 1;
    }

    public int solution2(int[] a) {
        int sum = 0;
        int max = a.length + 1;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        int expectedSum = (max * (max+1)) / 2;
        return expectedSum - sum;
    }
}
