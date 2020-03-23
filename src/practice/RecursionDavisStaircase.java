package practice;

/**
 *  @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
 * Progress: Done
 */
public class RecursionDavisStaircase {

    public static void main(String[] args) {
        System.out.println(stepPerms(1));
        System.out.println(stepPerms(2));
        System.out.println(stepPerms(3));
        System.out.println(stepPerms(4));
        System.out.println(stepPerms(5));
        System.out.println(stepPerms(6));
        System.out.println(stepPerms(7));
    }

    static int stepPerms(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
        int c1 = 1, c2 = 1, c3 = 2;
        for (int i = 2; i < n; i++) {
            int temp = c3 + c2 + c1;
            c1 = c2;
            c2 = c3;
            c3 = temp;
        }
        return c3;
    }

}
