package practice.codilitylessons.sieveoferatosthenes;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/
 * Progress: Done
 */
public class CountSemiPrimes {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20})));
    }

    public static int[] solution(int n, int[] p, int[] q) {
        int[] factorArray = getFactorizationArray(n);
        int[] semiPrimes = getSemiPrimes(factorArray);
        int[] prefixSums = getPrefixSums(semiPrimes);
        int[] answer = new int[p.length];
        for (int i = 0; i < p.length; i++) answer[i] = prefixSums[q[i]] - prefixSums[p[i]] + semiPrimes[p[i]];
        return answer;
    }

    private static int[] getPrefixSums(int[] semiPrimes) {
        int[] prefixSums = new int[semiPrimes.length];
        for (int i = 1; i < prefixSums.length; i++) prefixSums[i] = prefixSums[i-1] + semiPrimes[i];
        return prefixSums;
    }

    private static int[] getSemiPrimes(int[] primeArray) {
        int[] semiPrimes = new int[primeArray.length];
        for (int i = 2; i < primeArray.length; i++) {
            if (primeArray[i] == 0) continue;
            int first = primeArray[i];
            int second = i / first;
            if (primeArray[first] + primeArray[second] == 0) semiPrimes[i] = 1;
        }
        return semiPrimes;
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
