package practice.hackerranklessons.warmup;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EfeDaniel
 * Link: www.hackerrank.com/challenges/sock-merchant/problem
 * Progress: Done
 */
public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int current = ar[i];
            if (set.contains(current)) {
                answer++;
                set.remove(current);
            } else {
                set.add(current);
            }
        }
        return answer;
    }
}
