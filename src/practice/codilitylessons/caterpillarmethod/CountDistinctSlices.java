package practice.codilitylessons.caterpillarmethod;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/15-caterpillar_method/count_distinct_slices/
 * Codility Report Link: https://app.codility.com/demo/results/trainingXUCYUE-Y8K/
 * Progress: Done
 */
public class CountDistinctSlices {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[] {3,4,5,5,2}));
    }

    public static int solution(int m, int[] a) {
        int answer = 0;
        int start = 0, end = -1;
        Set<Integer> contents = new HashSet<>();
        while (end < a.length-1) {
            end++;
            if (!contents.add(a[end])) {
                while (a[start] != a[end]) {
                    contents.remove(a[start]);
                    start++;
                }
                start++;
            }
            answer += end - start + 1;
            if (answer > 1_000_000_000) return 1_000_000_000;
        }
        return answer;
    }
}
