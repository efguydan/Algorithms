package practice.codilitylessons.binarysearch;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 * Codility Report Link: https://app.codility.com/demo/results/trainingTNEAYE-U2J/
 * Progress: Done
 */
public class MinMaxDivision {

    public static void main(String[] args) {
        System.out.println(solution(3, 5, new int[]{2,1,5,1,2,2,2}));
    }

    public static int solution(int k, int m, int[] a) {
        int max = a[0], sum = 0;
        for (int num : a) {
            max = Math.max(max, num);
            sum += num;
        }

        int begin = max, end = sum, min = sum;

        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (check(mid, k, a)) {
                min = mid;
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return min;
    }

    private static boolean check(int num, int k, int[] a) {
        int i = 0, sum = 0;
        while (i < a.length) {
            sum += a[i];

            if (sum > num) {
                sum = a[i];
                k--;
                if (k == 0) return false;
            }
            i++;
        }
        return true;
    }

}
