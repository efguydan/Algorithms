package practice;

import java.util.Arrays;
import java.util.Scanner;

class MiscClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfTest = input.nextInt();

        for (int k = 0; k < numberOfTest; k++) {
            int numberOfHouses = input.nextInt();
            int priceToSpend = input.nextInt();
            System.out.println(numberOfHouses);
            System.out.println(priceToSpend);

            int[] pricesOfHouseNext = new int[numberOfHouses];
            for (int l = 0; l < numberOfHouses; l++) {
                pricesOfHouseNext[l] = input.nextInt();
            }
            System.out.println(Arrays.toString(pricesOfHouseNext));
        }
    }

}