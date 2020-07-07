package Competitions.CodeJam2020;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int matrixSize = input.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }
            System.out.println(String.format("Case #%d: %s", ks, solve(matrixSize, matrix)));
        }
    }

    private static String solve(int matrixSize, int[][] matrix) {
        Set<String> allMatrix = new HashSet<>();
        Set<Integer> horizontal = new HashSet<>();
        Set<Integer> vertical = new HashSet<>();
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (i == j) trace += matrix[i][j];

                String horizontalKey = i + "-h-" + matrix[i][j];
                String verticalKey = j + "-v-" + matrix[i][j];
                if (!allMatrix.add(horizontalKey)) horizontal.add(i);
                if (!allMatrix.add(verticalKey)) vertical.add(j);
            }
        }
        return trace + " " + horizontal.size() + " " + vertical.size();
    }

}
