package Competitions.KickStart2020;

import java.util.Scanner;

public class BusRoutes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int noBuses = input.nextInt();
            long lastDay = input.nextLong();
            long[] buses = new long[noBuses];
            for (int i = 0; i < noBuses; i++) buses[i] = input.nextLong();
            System.out.println(String.format("Case #%d: %d", ks, solve(lastDay, buses)));
        }
    }

    private static long solve(long lastDay, long[] buses) {
        for (int i = buses.length - 1; i >= 0; i--) {
            long bus = buses[i];
            lastDay = Math.min(bus * (lastDay / bus), lastDay);
        }
        return lastDay;
    }

}
