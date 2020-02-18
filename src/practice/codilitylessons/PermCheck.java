package practice.codilitylessons;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    public int solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= a.length; i++) set.add(i);
        for (int i = 0; i < a.length; i++) {
            set.remove(a[i]);
        }
        return set.isEmpty() ? 1 : 0;
    }
}
