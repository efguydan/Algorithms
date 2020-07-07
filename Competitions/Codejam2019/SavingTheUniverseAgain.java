package Competitions.Codejam2019;

import java.util.Scanner;

/**
 * Progress: Done
 */

public class SavingTheUniverseAgain {

    public static void savingTheUniverseAgain() {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int damage = input.nextInt();
            String pattern = input.next();
            int answer = solve(damage, pattern);
            String answerString = String.valueOf(answer);
            if (answer == -1) {
                answerString = "IMPOSSIBLE";
            }
            System.out.println(String.format("Case #%d: %s", ks, answerString));
        }
    }

    private static int solve(int damage, String pattern) {
        int totalChanges = 0;
        while (calculateDamage(pattern) > damage) {
            for (int i = pattern.length() - 1; i > 0; i--) {
                if (pattern.charAt(i) == 'S' && pattern.charAt(i - 1) == 'C') {
                    StringBuilder sb = new StringBuilder(pattern);
                    sb.setCharAt(i, 'C');
                    sb.setCharAt(i - 1, 'S');
                    pattern = sb.toString();
                    totalChanges++;
                    break;
                }
                if (i == 1) {
                    return -1;
                }
            }
        }
        return totalChanges;
    }

    private static int calculateDamage(String pattern) {
        int currentDamage = 1;
        int totalDamage = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'C') {
                currentDamage *= 2;
            } else {
                totalDamage += currentDamage;
            }
        }
        return totalDamage;
    }
}
