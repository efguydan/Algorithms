package competitions.IeeeXtreme2019;

import java.util.ArrayList;
import java.util.Scanner;

public class AveCeaser {

    private static ArrayList<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfInputs = in.nextInt();
        for (int i = 0; i < noOfInputs; i++) {
            String next = in.next();
            answerList.add(solve(next));
        }
    }

    private static Integer solve(String input) {
        return 0;
    }
}
