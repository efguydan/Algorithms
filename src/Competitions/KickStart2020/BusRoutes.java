package Competitions.KickStart2020;

import java.util.Scanner;

public class BusRoutes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int noBuses = input.nextInt();
            int lastDay = input.nextInt();
            int[] buses = new int[noBuses];
            for (int i = 0; i < noBuses; i++) buses[i] = input.nextInt();
            System.out.println(String.format("Case #%d: %d", ks, solve(lastDay, buses)));
        }
    }

    private static int solve(int lastDay, int[] buses) {
        for (int i = buses.length - 1; i >= 0; i--) {
            int bus = buses[i];
            lastDay = Math.min(bus * (lastDay / bus), lastDay);
        }
        return lastDay;
    }

}
