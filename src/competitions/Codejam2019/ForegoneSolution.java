package competitions.Codejam2019;

import java.util.Scanner;

public class ForegoneSolution {

    public static void foregoneSolution() {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            String number = input.next();
            solve(ks, number);
        }
    }

    private static void solve(int index, String number) {
        StringBuilder firstNumber = new StringBuilder();
        StringBuilder secondNumber = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '4') {
                firstNumber.append("3");
                secondNumber.append("1");
            } else {
                firstNumber.append(number.charAt(i));
                if (secondNumber.length() > 0) {
                    secondNumber.append("0");
                }
            }
        }
        System.out.println(String.format("Case #%d: %s %s", index,
                firstNumber.toString(), secondNumber.toString()));
    }
}
