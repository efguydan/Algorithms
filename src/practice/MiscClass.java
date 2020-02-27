package practice;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.ISO_8859_1;

class MiscClass {

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        int answer = 0;
        for (int i = 0; i < T; i++) {
            answer += findHackerRank(in.nextLine());
        }
        System.out.println(answer);
    }

    public static int findHackerRank(String string) {
        if (string.toLowerCase().contains("hackerrank")) {
            return 1;
        }
        return 0;
    }
}