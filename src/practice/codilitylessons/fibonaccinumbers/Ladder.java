package practice.codilitylessons.fibonaccinumbers;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/13-fibonacci_numbers/ladder/
 * Massive help from: https://github.com/Mickey0521/Codility/blob/master/Ladder.java
 * Progress: Done
 */
public class Ladder {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 4, 5, 5, 1}, new int[]{3, 2, 4, 3, 1})));
    }

    public static int[] solution(int[] a, int[] b) {
        int[] answer = new int[a.length];
        int[] ladderArray = getLadderArray(getMax(a));

        for (int i = 0; i < answer.length; i++) {
            answer[i] = ladderArray[a[i]] % (1 << b[i]);
        }

        return answer;
    }

    private static int[] getLadderArray(int n) {
        int[] lArray = new int[++n];
        lArray[0] = 1;
        lArray[1] = 1;
        for (int i = 2; i < n; i++) {
            lArray[i] = (lArray[i-1] + lArray[i-2]) % (1 << 30);
        }
        return lArray;
    }

    private static int getMax(int[] a) {
        int max = a[0];
        for (int current : a) if (current > max) max = current;
        return max;
    }

}
