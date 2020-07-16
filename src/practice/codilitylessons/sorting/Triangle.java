package practice.codilitylessons.sorting;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/6-sorting/triangle/
 * Progress: Done
 */
public class Triangle {
    public int solution(int[] a) {
        Arrays.sort(a);
        if (a.length < 3) return 0;
        for (int i = 2; i < a.length; i++) {
            if (a[i] - a[i-1] < a[i-2]) return 1;
        }
        return 0;
    }
}
