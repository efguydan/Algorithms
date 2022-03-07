package competitions.CodeJam2020;

import java.util.Scanner;

public class PatternMatching {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int num = input.nextInt();
            String[] arr = new String[num];
            for (int i = 0; i < num; i++) {
                arr[i] = input.next();
            }
            System.out.println(String.format("Case #%d: %s", ks, solve(num, arr)));
        }
    }

    private static String solve(int num, String[] arr) {
        String before = "";
        String after = "";
        for (int i = 0; i < num; i++) {
            String tempBefore = getBefore(arr[i]);
            String tempAfter = getAfter(arr[i]);

            if (tempBefore.length() > before.length()) {
                if (tempBefore.startsWith(before)) before = tempBefore; else return "*";
            } else {
                if (!before.endsWith(tempBefore)) return "*";
            }

            if (tempAfter.length() > after.length()) {
                if (tempAfter.endsWith(after)) after = tempAfter; else return "*";
            } else {
                if (!after.endsWith(tempAfter)) return "*";
            }
        }
        return before + after;
    }

    private static String getBefore(String s) {
        return s.substring(0, s.indexOf("*"));
    }

    private static String getAfter(String s) {
        return s.substring(s.indexOf("*") + 1);
    }
}
