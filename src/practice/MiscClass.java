package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MiscClass {

    public static void main(String[] args) {
        int[] nums1 = {5, -7, 3, 5, -2, 4, -1};
        System.out.println(goldenMaxSlice(nums1));
    }

    private static int goldenMaxSlice(int[] a) {
        int maxEnding = 0, maxSlice = 0;
        for (int i : a) {
            maxEnding = Math.max(0, maxEnding + i);
            maxSlice = Math.max(maxSlice, maxEnding);
        }
        return maxSlice;
    }

}