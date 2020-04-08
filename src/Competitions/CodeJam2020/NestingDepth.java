package Competitions.CodeJam2020;

import java.util.Scanner;

public class NestingDepth {

    static String answer = "";
    static int[] arr;
    static int index = 0;
    static int nest = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            String s = input.next();
            System.out.println(String.format("Case #%d: %s", ks, solve(s)));
        }
    }

    private static String solve(String s) {
        answer = "";
        index = 0;
        nest = 0;
        arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        df();
        return answer;
    }

    private static void df() {
        if (index >= arr.length) return;
        if (arr[index] == nest) {
            answer += arr[index];
            index++;
            df();
        } else if (nest > arr[index]) {
            nest--;
        } else {
            answer += "(";
            nest++;
            df();
            answer += ")";
            if (index < arr.length) df();
        }
    }
}
