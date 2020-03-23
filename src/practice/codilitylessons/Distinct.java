package practice.codilitylessons;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/6-sorting/distinct/
 * Progress: Done
 */
public class Distinct {
    public int solution(int[] a) {
        if (a.length == 0) return 0;
        int answer = 1;
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i-1]) answer++;
        }
        return answer;
    }
}
