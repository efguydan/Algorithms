package practice.interviewcake.combinatoricsprobabilityandothermath;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/find-in-ordered-set?course=fc1&section=combinatorics-probability-math
 * Progress: Done
 */
public class FindInOrderedSet {

    public static void main(String[] args) {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10);
        System.out.println(result);
    }

    public static boolean contains(int[] a, int n) {
        int start = 0;
        int end = a.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] > n) {
                end = mid - 1;
            } else if (a[mid] < n) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return a[end] == n;
    }

}
