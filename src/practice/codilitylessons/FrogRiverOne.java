package practice.codilitylessons;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 * Progress: Done
 */
public class FrogRiverOne {
    public int solution(int x, int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= x; i++) set.add(i);
        for (int j = 0; j < a.length; j++) {
            set.remove(a[j]);
            if (set.isEmpty()) return j;
        }
        return -1;
    }

    public int solution2(int x, int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
            if (set.size() == x) return i;
        }
        return a.length;
    }
}
