package practice.interviewcake.recursion;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/nth-fibonacci?course=fc1&section=dynamic-programming-recursion
 * Progress: Done
 */
public class ComputeTheNthFibonacciNumber {

    public static int fib(int n) {
        if (n < 0) throw new IllegalArgumentException("Index was negative.");
        if (n < 2) return n;

        int a = 1;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

}
