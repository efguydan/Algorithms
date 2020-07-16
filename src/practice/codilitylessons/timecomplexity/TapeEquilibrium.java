package practice.codilitylessons.timecomplexity;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 * Progress: Done
 */
public class TapeEquilibrium {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 4, 3}));
        System.out.println(solution(new int[]{-2, -3, -4, -1}));
    }

    public static int solution(int[] a) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < a.length; i++) sum += a[i];
        int left = 0;
        int right = sum - left;
        for (int j = 0; j < a.length - 1; j++) {
            left += a[j];
            right -= a[j];
            int currentMin = Math.abs(left - right);
            if (currentMin < min) min = currentMin;
            if (min == 0) break;
        }
        return min;
    }
}
