package practice.codilitylessons.sieveoferatosthenes;

import java.util.*;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/
 * Progress: Done
 */
public class CountNonDivisible {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution3.solution(new int[]{3, 1, 2, 3, 6})));
    }

    // Got 100% for this
    // Although didnt use of Sieve of Eratosthenes

    public static class Solution3 {
        public static int[] solution(int[] a) {
            int max = getMax(a);
            int[] elementCount = getCounts(a, max);
            int[] answer = new int[a.length];

            for (int i = 0; i < a.length; i++) {
                int localAnswer = a.length;
                int j;

                for (j = 1; j < Math.sqrt(a[i]); j++) {
                    if (a[i] % j != 0) continue;
                    localAnswer -= elementCount[j];
                    localAnswer -= elementCount[a[i]/j];
                }

                if (j == Math.sqrt(a[i])) localAnswer -= elementCount[j];
                answer[i] = localAnswer;
            }
            return answer;
        }

        private static int[] getCounts(int[] a, int max) {
            int [] counts = new int [max+1];
            for (int i=0; i<a.length; i++) counts[a[i]]++;
            return counts;
        }
    }

    // Got 55% for this too

    public static class Solution2 {

        public static int[] solution(int[] a) {
            int[] answer = new int[a.length];
            int[] factorArray = getFactorizationArray(getMax(a));

            HashMap<Integer, Integer> elementCount = new HashMap<>();
            for (int element: a) elementCount.put(element, elementCount.getOrDefault(element, 0) + 1);

            Set<Integer> keys = elementCount.keySet();

            HashMap<Integer, Integer> answerCount = new HashMap<>();

            for (int element : keys) {
                Set<Integer> factors = getFactors(element, factorArray);
                int localAnswer = a.length;
                for (int factor : factors) localAnswer -= elementCount.getOrDefault(factor, 0);
                answerCount.put(element, localAnswer);
            }

            for (int i = 0; i < a.length; i++) {
                answer[i] = answerCount.get(a[i]);
            }

            return answer;
        }

        private static Set<Integer> getFactors(int element, int[] factorArray) {
            Set<Integer> answer = new HashSet<>();
            int temp = element;
            answer.add(temp);
            answer.add(1);
            while (factorArray[temp] > 0) {
                temp /= factorArray[temp];
                answer.add(temp);
                answer.add(element/temp);
            }
            return answer;
        }

    }


    // Got 55% for this

    public static class Solution1 {

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
