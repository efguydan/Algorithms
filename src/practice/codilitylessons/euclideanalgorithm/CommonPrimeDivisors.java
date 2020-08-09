package practice.codilitylessons.euclideanalgorithm;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors/
 * Progress: Done
 */
public class CommonPrimeDivisors {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{15, 10, 3}, new int[]{75, 30, 5}));
        System.out.println(solution(new int[]{2, 1, 2}, new int[]{1, 2, 2}));
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            if (hasSamePrimeDivisors(a[i], b[i])) answer++;
        }
        return answer;
    }

    private static boolean hasSamePrimeDivisors(int m, int n) {
        int gcd = getGcd(m, n);
        if (removeCommonPrimeDivisors(m, gcd) != 1) return false;
        if (removeCommonPrimeDivisors(n, gcd) != 1) return false;
        return true;
    }

    public static int removeCommonPrimeDivisors(int p, int q) {
        int gcd = 0;
        do {
            gcd = getGcd(p, q);
            p /= gcd;
        } while (gcd != 1);
        return p;
    }

    private static int getGcd(int m, int n) {
        if (m == n) return m;
        else if (min(m, n) == 0) return max(m, n);
        else return getGcd(min(m, n), max(m, n) % min(m, n));
    }
    
}
