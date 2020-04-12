package practice.codilitylessons;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
 * Progress: Done
 */
public class MaxDoubleSliceSum {

    public static void main(String[] args) {
        int[] a = {3, 2, 6, -1, 4, 5, -1, 2};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int[] start = maxSliceFromStart(a);
        int[] end = maxSliceFromEnd(a);
        int max = 0;
        for (int i = 1; i < a.length - 1; i++) max = Math.max(max, start[i-1] + end[i+1]);
        return max;
    }

    private static int[] maxSliceFromStart(int[] a) {
        int[] answer = new int[a.length];
        int runningMax = 0;
        for (int i = 1; i < a.length - 1; i++) {
            runningMax = Math.max(0, runningMax + a[i]);
            answer[i] = runningMax;
        }
        return answer;
    }

    private static int[] maxSliceFromEnd(int[] a) {
        int[] answer = new int[a.length];
        int runningMax = 0;
        for (int i = a.length - 2; i > 0; i--) {
            runningMax = Math.max(0, runningMax + a[i]);
            answer[i] = runningMax;
        }
        return answer;
    }
}
