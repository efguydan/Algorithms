package competitions.IeeeXtreme2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CharlieNewPC {

    public static int sum = 0;
    public static int answer = 0;

    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            sum = 0;
            int totalSum = in.nextInt();
            int noOfComponents = in.nextInt();
            int[] components = new int[noOfComponents];
            for (int j = 0; j < noOfComponents; j++) {
                components[j] = in.nextInt();
            }
            ArrayList<int[]> componentTypePrices = new ArrayList<>();
            for (int k = 0; k < noOfComponents; k++) {
                int[] temp = new int[components[k]];
                for (int l = 0; l < components[k]; l++) {
                    temp[l] = in.nextInt();
                }
                Arrays.sort(temp);
                componentTypePrices.add(temp);
            }
            solve(totalSum, components, componentTypePrices);
        }
    }

    private static void solve(int totalSum, int[] components, ArrayList<int[]> componentTypePrices) {
        for (int[] temp : componentTypePrices) {
            sum += temp[0];
        }
        if(sum > totalSum) {
            System.out.println(0);
            return;
        }
        answer = sum;
        int[] indices = new int[components.length];
        addMore(totalSum, sum, componentTypePrices, indices, components);
        System.out.println(answer);
    }

    private static void addMore(int totalSum, int sum, ArrayList<int[]> componentTypePrices, int[] indices, int[] components) {
        while (increaseCurrentIndices(indices, components)) {
            if (sum <= totalSum && sum > answer) answer = sum;
            if (answer == totalSum) return;
            sum = 0;
            for (int p = 0; p < components.length; p++) {
                sum += componentTypePrices.get(p)[indices[p]];
            }
            if (sum > totalSum) {

            }
        }
    }

    private static boolean increaseCurrentIndices(int[] indices, int[] components) {
        for (int i = indices.length - 1; i >= 0; i--) {
            if (indices[i] < components[i]-1) {
                indices[i]++;
                return true;
            } else {
                indices[i] = 0;
            }
        }
        return false;
    }
}


