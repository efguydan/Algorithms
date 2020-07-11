package practice.codilitylessons;

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/unique-paths/
 * Progress: Done
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(10, 10));
    }

    public static int uniquePaths(int m, int n) {
        int row = m + n - 2;
        int column = Math.min(m, n) - 1;
        return combination(row, column);
    }

    public static int combination(int n, int r) {
        if (r > n / 2) r = n - r;

        long numerator = 1L, denominator = 1L;
        for (int i = 1; i <= r; i++){
            numerator *= n-i+1;
            denominator *= i;
        }

        return (int) (numerator / denominator);
    }

}
