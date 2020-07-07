package practice.codilitylessons;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 * Progress: Done
 */
public class MissingInteger {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(nums1));
    }

    public static int solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) set.add(a[i]);
        }
        for (int j = 1; j <= set.size(); j++) {
            if (!set.contains(j)) return j;
        }
        return set.size() + 1;
    }
}
