package Competitions.KickStart2020;

import java.util.Arrays;
import java.util.Scanner;

public class Allocation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int numberOfHouses = input.nextInt();
            int budget = input.nextInt();
            int[] housesPrice = new int[numberOfHouses];
            for (int i = 0; i < numberOfHouses; i++) {
                housesPrice[i] = input.nextInt();
            }
            System.out.println(String.format("Case #%d: %d", ks, solve(numberOfHouses, budget, housesPrice)));
        }
    }

    private static int solve(int numberOfHouses, int budget, int[] housesPrice) {
        int affordable = 0;
        Arrays.sort(housesPrice);
        for (int i = 0; i < numberOfHouses; i++) {
            if (housesPrice[i] > budget) {
                return affordable;
            } else {
                budget -= housesPrice[i];
                affordable++;
            }
        }
        return affordable;
    }

}
