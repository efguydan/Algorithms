package competitions.Codejam2019;

import java.util.Scanner;

public class BacterialTactics {

    public static void bacterialTactics() {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int rows = input.nextInt();
            int cols = input.nextInt();
            String[][] gameMatrix = new String[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    gameMatrix[i][j] = input.next();
                }
            }
            System.out.println(String.format("Case #%d: %d", ks, solve(rows, cols, gameMatrix)));
        }
    }

    private static int solve(int rows, int cols, String[][] gameMatrix) {
        int noOfBeccaMoves = 0;
        boolean beccaturn = true;
        boolean movesAvailable = true;
        while (movesAvailable) {
            gameMatrix = playOptimizedMove(rows, cols, gameMatrix);
        }

        return noOfBeccaMoves;
    }

    private static String[][] playOptimizedMove(int rows, int cols, String[][] gameMatrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

            }
        }
        return gameMatrix;
    }
}