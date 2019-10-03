package practice;

import java.util.*;

class MiscClass {
    public static void main(String args[]) {
        String[] arr = new String[] {"0000", "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888", "9999"};
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String input = in.next();
            boolean answer = input.matches("^([4,5,6]\\d{3}[-]?\\d{4}[-]?\\d{4}[-]?\\d{4})$");
            input = input.replaceAll("-", "");
            for (String string : arr) {
                answer = answer && !(input.contains(string));
                if (answer == false) break;
            }
            System.out.println(answer ? "Valid" : "Invalid");
        }
    }
}