package practice.codilitylessons.euclideanalgorithm;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/
 * Progress: Done
 */
public class ChocolatesByNumbers {

    public static void main(String[] args) {
        System.out.println(solution(10, 4));
        System.out.println(solution(947853, 4453));
    }

    public static int solution(int n, int m) {
        return (int) (getLcm(m, n) / m);
    }

    private static long getLcm(int m, int n) {
        return ((long) m * (long) n / getGcd(m, n));
    }

    private static int getGcd(int m, int n) {
        if (m == n) return m;
        else if (min(m, n) == 0) return max(m, n);
        else return getGcd(min(m, n), max(m, n) % min(m, n));
    }
}
