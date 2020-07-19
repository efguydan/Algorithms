package practice.codilitylessons.sieveoferatosthenes;

import java.util.*;

public class CountNonDivisible {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 1, 2, 3, 6})));
    }

    public static int[] solution(int[] a) {
        int[] factorArray = getFactorizationArray(getMax(a));
        int[] answer = new int[a.length];

        Map<Integer, Integer> unique = new HashMap<>();
        for (int i : a) unique.put(i, 0);

        for (int i : unique.keySet()) {
            unique.put(i, solve(i, a, factorArray));
        }

        for (int i = 0; i < a.length; i++) {
            answer[i] = unique.get(a[i]);
        }

        return answer;
    }

    private static int solve(int i, int[] a, int[] factorArray) {
        int answer = a.length;
        for (int divisor : a) {
            if (i == divisor || divisor == 1) {
                answer--;
                continue;
            }
            if (divisor > i) continue;
            int temp = i;
            do {
                if (factorArray[temp] == 0) break;
                temp /= factorArray[temp];
                int other = i / temp;
                if (temp == divisor || other == divisor) {
                    answer--;
                    break;
                }
                else if (temp < divisor) break;
            } while (temp != 0);
        }
        return answer;
    }

    private static int getMax(int[] a) {
        int max = a[0];
        for (int current : a) if (current > max) max = current;
        return max;
    }

    public static int[] getFactorizationArray(int n) {
        int[] array = new int[++n];
        for (int i = 2; i < n; i++) {
            if (array[i] != 0) continue;
            int k = i * 2;
            while (k < n) {
                if (array[k] == 0) array[k] = i;
                k += i;
            }
        }
        return array;
    }

}
