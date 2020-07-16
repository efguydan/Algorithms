package practice.codilitylessons.prefixsums;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 * Progress: Done
 */
public class MinAvgTwoSlice {

    public int solution(int[] a) {
        double minAvg = (double) (a[0] + a[1]) / 2;
        int minIndex = 0;
        for (int i = 0; i < a.length-1; i++) {
            if ((double) (a[i] + a[i+1]) / 2 < minAvg) {
                minAvg = (double) (a[i] + a[i+1]) / 2;
                minIndex = i;
            }
        }
        if (a.length < 3 ) return minIndex;

        for (int i = 0; i < a.length - 2; i++) {
            if ((double) (a[i] + a[i+1] + a[i+2]) / 3 < minAvg) {
                minAvg = (double) (a[i] + a[i+1] + a[i+2]) / 3;
                minIndex = i;
            }
        }

        if (a.length < 4 ) return minIndex;

        for (int i = 0; i < a.length - 3; i++) {
            if ((double) (a[i] + a[i+1] + a[i+2] + a[i+3]) / 4 < minAvg) {
                minAvg = (double) (a[i] + a[i+1] + a[i+2] + a[i+3]) / 4;
                minIndex = i;
            }
        }
        return minIndex;
    }
}
