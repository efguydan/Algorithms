package practice.codilitylessons.binarysearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/14-binary_search_algorithm/nailing_planks/
 * Codility Report Link: https://app.codility.com/demo/results/trainingNGX5U7-8ER/
 * Progress: Done
 */
public class NailingPlanks {

    public static void main(String[] args) {

    }

    public int solution(int[] a, int[] b, int[] c) {
        int n = a.length, m = c.length;
        int[][] sortedNail = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedNail[i][0] = c[i];
            sortedNail[i][1] = i;
        }

        Arrays.sort(sortedNail, Comparator.comparingInt(o -> o[0]));
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = getMinIndex(a[i], b[i], sortedNail, result);
            if (result == -1) return -1;
        }
        return ++result;
    }

    private int getMinIndex(int startPlank, int endPlank, int[][] nails, int preIndex) {
        int min = 0, max = nails.length - 1, minIndex = -1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (nails[mid][0] < startPlank)
                min = mid + 1;
            else if (nails[mid][0] > endPlank)
                max = mid - 1;
            else {
                max = mid - 1;
                minIndex = mid;
            }
        }
        if (minIndex == -1) return -1;
        int minIndexOrigin = nails[minIndex][1];
        for (int i = minIndex; i < nails.length; i++) {
            if (nails[i][0] > endPlank) break;
            minIndexOrigin = Math.min(minIndexOrigin, nails[i][1]);
            if (minIndexOrigin <= preIndex) return preIndex;
        }
        return minIndexOrigin;
    }

}
