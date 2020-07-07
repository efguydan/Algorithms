package practice.codilitylessons;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 * Progress: Done
 */
public class MaxCounters {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    }

    public static int[] solution(int n, int[] a) {
        int[] array = new int[n];
        int lastUpdate = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= n) {
                int temp = array[a[i]-1] < lastUpdate ? lastUpdate + 1 : array[a[i]-1] + 1;
                array[a[i]-1] = temp;
                if (temp > max) max = temp;
            } else {
                lastUpdate = max;
            }
        }
        for (int j = 0; j < array.length; j++) {
            if (array[j] < lastUpdate) array[j] = lastUpdate;
        }
        return array;
    }
}
