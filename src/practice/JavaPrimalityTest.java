package practice;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/java-primality-test/problem
 * Progress: Done
 */
public class JavaPrimalityTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        scanner.close();

        System.out.println(isPrime(n));
    }

    public static String isPrime(BigInteger n) {
        return getAnswer(n.isProbablePrime(5));
    }

    public static String getAnswer(boolean b) {
        return b ? "prime" : "not prime";
    }

}
