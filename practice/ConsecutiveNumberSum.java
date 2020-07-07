package practice;

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/consecutive-numbers-sum/
 * Progress: Done
 */

public class ConsecutiveNumberSum {

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(5));
        System.out.println(consecutiveNumbersSum(9));
        System.out.println(consecutiveNumbersSum(15));
        System.out.println(consecutiveNumbersSum(1));
    }

    public static int consecutiveNumbersSum(int N) {
        int answer = 0;
        Double div, num = (double) N, currentDivisor = 1.0, maxDivisor = Math.ceil(num / 2);
        while (currentDivisor.intValue() <= maxDivisor) {
            div = N / currentDivisor;
            if ((currentDivisor%2) == 0 ) {
                if (isEqualToPointFive(div)) answer++;
            } else {
                if (isEqualToZero(div)) answer++;
            }
            if (div - currentDivisor / 2 <= 1.0) break;
            currentDivisor += 1.0;
        }
        return answer;
    }

    private static boolean isEqualToPointFive(Double num) {
        Double decimal = num - num.intValue();
        return decimal == 0.5;
    }

    private static boolean isEqualToZero(Double num) {
        Double decimal = num - num.intValue();
        return decimal == 0.0;
    }
}
