package practice.CtCI.arraysandstrings;

import java.util.Arrays;

/**
 *  @author EfeDaniel
 * Link: Ctci Page 91, 1.9
 * Progress: Passed all thinkable testcases yet
 */
public class StringRotation {

    public static void main(String[] args) {
        System.out.println(stringRotation("waterbottle", "erbottlewat"));
        System.out.println(stringRotation("efe", "eer"));
    }


    // Solution 1
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    public static boolean stringRotation(String s1, String s2) {
        s1 = sort(s1);
        s2 = sort(s2);

        return isSubstring(s1, s2);
    }

    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    public static String sort(String string) {
        char[] arr = string.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
