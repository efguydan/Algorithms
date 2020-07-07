package practice.CtCI.arraysandstrings;

/**
 *  @author EfeDaniel
 * Link: Ctci Page 91, 1.7
 * Progress: Done. Not tested
 */
public class RotateMatrix {

    public static void main(String[] args) {
    }


    // Solution 1
    // Time Complexity: O(n ^ 2)
    // Space Complexity: O(n ^ 2)
    public static int[][] rotateMatrix(int[][] matrix) {
        if (matrix.length == 0) return matrix;

        int[] indices = new int[]{0,0};

        int[][] answer = new int[matrix.length][matrix.length];

        for (int j = 0; j < matrix.length; j++) {
            for (int i = matrix.length - 1; i >= 0; i++) {
                answer[indices[0]][indices[1]] = matrix[i][j];
                moveToNextIndex(indices, matrix.length - 1);
            }
        }

        return answer;
    }

    private static void moveToNextIndex(int[] indices, int lastIndex) {
        if (indices[1] < lastIndex) {
            indices[1] = indices[1] + 1;
        } else {
            indices[0] = indices[0] + 1;
            indices[1] = 0;
        }
    }
}
