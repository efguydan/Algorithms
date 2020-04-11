package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MiscClass {

    public static void main(String[] args) {
        int[] a = {6,8,4,6,8,6,6,4};
        System.out.println(goldenLength(a));
    }

    public static int goldenLength(int[] a) {
        int n = a.length;
        int size = 0;
        int value = 0;
        for (int k = 0; k < n; k++) {
            if (size == 0) {
                size++;
                value = a[k];
            } else {
                if (value != a[k]) {
                    size--;
                } else {
                    size++;
                }
            }
        }
        int candidate = -1;
        if (size > 0) candidate = value;
        int leader = -1;
        int count = 0;
        for (int k = 0; k < n; k++) {
            if (a[k] == candidate) count++;
        }
        if (count > n/2) {
            leader = candidate;
        }
        return leader;
    }

}