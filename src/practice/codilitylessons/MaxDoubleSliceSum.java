package practice.codilitylessons;

import java.util.Arrays;

public class MaxDoubleSliceSum {

    public static void main(String[] args) {
        int[] a = {3, 2, 6, -1, 4, 5, -1, 2};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int[] start = new int[a.length];
        start = goldenMaxSlice(a);
        System.out.println(Arrays.toString(start));
        return 0;
    }

    private static int[] goldenMaxSlice(int[] a) {
        int[] answer = new int[a.length];
        int runningMax = 0;
        for (int i = 1; i < a.length - 1; i++) {
            runningMax = Math.max(0, runningMax + a[i]);
            answer[i] = runningMax;
        }
        return answer;
    }
}
