package practice.codilitylessons;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 * Progress: Done
 */
public class MaxProductOfThree {
    public int solution(int[] a) {
        int l = a.length-1;
        Arrays.sort(a);
        int c1 = a[0] * a[1] * a[l];
        int c2 = a[l-2] * a[l-1] * a[l];
        return Math.max(c2, c1);
    }
}
