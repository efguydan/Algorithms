package practice.CtCI.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

/**
 *  @author EfeDaniel
 * Link: Ctci Page 91, 1.8
 * Progress: Done. Not tested yet
 */
public class ZeroMatrix {

    public static void main(String[] args) {

    }


    // Solution 1
    // Time Complexity: O(m * n)
    // Space Complexity: O(m + n)
    public static int[][] zeroMatrix(int[][] matrix) {
        if (matrix.length == 0) return matrix;

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        for (int row : rowSet) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }

        for (int column : columnSet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }

        return matrix;
    }

}
