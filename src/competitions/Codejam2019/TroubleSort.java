package competitions.Codejam2019;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Progress: Not Done
 */
public class TroubleSort {

    public static void troubleSort() {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int noOfInputs = input.nextInt();
            int[] numberArray = new int[noOfInputs];
            for (int i = 0; i < noOfInputs; i++) {
                numberArray[i] = input.nextInt();
            }
            System.out.println(String.format("Case #%d: %s", ks, solve2(numberArray)));
        }
    }

    private static String solve2(int[] numberArray) {
        int[] oddArray = new int[numberArray.length / 2];
        int[] evenArray = new int[(int) Math.ceil((double) numberArray.length / 2)];
        for (int i = 0; i < numberArray.length; i++) {
            if (i % 2 == 0) {
                evenArray[i / 2] = numberArray[i];
            } else {
                oddArray[i / 2] = numberArray[i];
            }
        }
        Arrays.sort(evenArray);
        Arrays.sort(oddArray);
        for (int i = 0; i < numberArray.length; i++) {
            if (i % 2 == 0) {
                numberArray[i] = evenArray[i / 2];
            } else {
                numberArray[i] = oddArray[i / 2];
            }
            System.out.print(numberArray[i] + " ");
            if (i > 1 && numberArray[i] < numberArray[i - 1]) {
                return String.valueOf(i - 1);
            }
        }
        return "OK";
    }

    private static String solve(int[] numberArray) {
        boolean changesMade = true;
        while (changesMade) {
            changesMade = false;
            for (int j = 0; j < numberArray.length - 2; j++) {
                if (numberArray[j] > numberArray[j + 2]) {
                    int temp = numberArray[j];
                    numberArray[j] = numberArray[j + 2];
                    numberArray[j + 2] = temp;
                    changesMade = true;
                }
                System.out.println();
            }
        }
        for (int i = 1; i < numberArray.length; i++) {
            if (numberArray[i] < numberArray[i - 1]) {
                return String.valueOf(i - 1);
            }
        }
        return "OK";
    }
}
