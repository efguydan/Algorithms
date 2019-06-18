package Competitions.Codejam2019;

import java.util.Scanner;

public class YouCanGoYourOwnWay {

    public static void youCanGoYourOwnWay() {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int dimension = input.nextInt();
            String lydiaPattern = input.next();
            System.out.println(String.format("Case #%d: %s", ks, solve2(dimension, lydiaPattern)));
        }
    }

    private static String solve3(int dimension, String lydiaPattern) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < lydiaPattern.length(); i++) {
            answer.append(negate(lydiaPattern.charAt(i)));
        }
        return answer.toString();
    }

    private static String solve2(int dimension, String lydiaPattern) {
        StringBuilder answer = new StringBuilder();
        int lastIndex = lydiaPattern.length() - 1;
        char firstChar = lydiaPattern.charAt(0);
        char lastChar = lydiaPattern.charAt(lastIndex);
        if (firstChar != lastChar) {
            for (int i = 0; i < dimension - 1; i++) {
                answer.append(lastChar);
            }
            for (int i = 0; i < dimension - 1; i++) {
                answer.append(firstChar);
            }
        } else {
            answer.append(negate(firstChar));
            String toCheck = String.format("%s%s", negate(firstChar), negate(firstChar));
            int startIndex = lydiaPattern.indexOf(toCheck) - 1;
            for (int i = 1; i < startIndex; i++) {
                answer.append(negate(firstChar));
            }
            for (int i = 0; i < dimension - 1; i++) {
                answer.append(firstChar);
            }
            for (int i = answer.length(); i < lydiaPattern.length(); i++) {
                answer.append(negate(firstChar));
            }
        }
        return answer.toString();
    }

    private static char negate(char c) {
        if (c == 'S') {
            return 'E';
        }
        return 'S';
    }

    private static String solve(int dimension, String lydiaPattern) {
        StringBuilder answer = new StringBuilder();
        if (lydiaPattern.charAt(0) == 'S') {
            answer.append("E");
            answer.append("S");
        } else {
            answer.append("S");
            answer.append("E");
        }
        int length = lydiaPattern.length();
        for (int i = 1; i < length; i++) {
            if (lydiaPattern.charAt(i) == lydiaPattern.charAt(i - 1)) {
                answer.append(lydiaPattern.charAt(i));
            } else {
                if (i == length - 1 && lydiaPattern.charAt(i) == 'S') {
                    answer.append("E");
                } else if (i == length - 1 && lydiaPattern.charAt(i) == 'E') {
                    answer.append("S");
                } else if (lydiaPattern.charAt(i) == lydiaPattern.charAt(i - 1)) {
                    answer.append(lydiaPattern.charAt(i));
                } else if (lydiaPattern.charAt(i) != lydiaPattern.charAt(i - 1)) {
                    if (lydiaPattern.charAt(i + 1) == 'S') {
                        answer.append("E");
                    } else {
                        answer.append("S");
                    }
                }
            }
        }
        answer.replace(answer.length() - 1, answer.length(), "");
        return answer.toString();
    }
}
