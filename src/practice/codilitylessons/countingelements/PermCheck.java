package practice.codilitylessons.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 * Progress: Done
 */
public class PermCheck {
    public int solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= a.length; i++) set.add(i);
        for (int i = 0; i < a.length; i++) set.remove(a[i]);
        return set.isEmpty() ? 1 : 0;
    }
}
