package Competitions.KickStart2020;

import java.util.Scanner;

/**
 * Missing second testcase: RE
 */
public class RobotPathDecoding {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            indexToJumpTo = 0;
            String pattern = input.next();
            System.out.println(String.format("Case #%d: %s", ks, solve(pattern)));
        }
    }

    private static String solve(String pattern) {
        String fullPattern = getFullPattern(pattern, 0, 1);
        Pair pair = traverse(fullPattern.toCharArray());
        return pair.toString();
    }

    private static Pair traverse(char[] patternArray) {
        Pair pair = new Pair();
        for (char c : patternArray) {
            switch (c) {
                case 'N':
                    pair.y = getNextPosition(pair.y, -1);
                    break;
                case 'S':
                    pair.y = getNextPosition(pair.y, 1);
                    break;
                case 'E':
                    pair.x = getNextPosition(pair.x, 1);
                    break;
                case 'W':
                    pair.x = getNextPosition(pair.x, -1);
                    break;
            }
        }
        return pair;
    }

    private static int getNextPosition(int current, int toAdd) {
        if (current == 1_000_000_000 && toAdd == 1) return 1;
        else if (current ==  1 && toAdd == -1) return 1_000_000_000;
        else return current + toAdd;
    }

    static int indexToJumpTo = 0;
    private static String getFullPattern(String pattern, int index, int multiplier) {
        StringBuilder answer = new StringBuilder();
        char[] arr = pattern.toCharArray();
        for (int i = index; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                answer.append(arr[i]);
            } else {
                if (arr[i] == ')') {
                    indexToJumpTo = i;
                    break;
                }
                if (arr[i] == '(') continue;
                answer.append(getFullPattern(pattern, i+1, Integer.parseInt(String.valueOf(arr[i]))));
                i = indexToJumpTo;
            }
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < multiplier; i++) temp.append(answer);
        return temp.toString();
    }

    static class Pair {

        int x;
        int y;
        Pair () { x = 1; y = 1; }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

}
