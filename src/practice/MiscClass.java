package practice;

import java.util.Scanner;

public class MiscClass {

    public static void main(String[] args) {
        System.out.print("Enter number: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        boolean numberIsPerfect = isPerfect(number);

        if (numberIsPerfect == true) {
            System.out.println(number + " is a perfect number");
        } else {
            System.out.println(number + " is not a perfect number");
        }

    }

    private static boolean isPerfect(int number) {
        int sumOfFactors = 0;

        for (int i = 1; i <= number/2; i++) {
            if (number % i == 0) {
                sumOfFactors = sumOfFactors + i;
            }
        }
        return sumOfFactors == number;
    }

}