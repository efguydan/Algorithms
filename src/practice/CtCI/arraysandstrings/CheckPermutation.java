package practice.CtCI.arraysandstrings;

import java.util.Arrays;

/**
 *  @author EfeDaniel
 * Link: Ctci Page 90, 1.2
 * Progress: Passed all thinkable testcases yet
 */
public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println(checkPermutation2("efe", "fee"));
        System.out.println(checkPermutation2("efe", "Fee"));
        System.out.println(checkPermutation2("", ""));
    }


    // Solution 1
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    public static boolean checkPermutation1(String s1, String s2) {
        return (s1.length() == s2.length()) && sort(s1).equals(sort(s2));
    }

    public static String sort(String s) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        return new String(sArray);
    }


    // Solution 2
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static boolean checkPermutation2(String s1, String s2) {
        int[] charFound = new int[128];
        for (char c : s1.toCharArray()) charFound[c]++;
        for (char c : s2.toCharArray()) {
            charFound[c]--;
            if (charFound[c] < 0) return false;
        }
        return true;
    }

}
