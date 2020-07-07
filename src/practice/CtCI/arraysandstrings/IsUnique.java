package practice.CtCI.arraysandstrings;

/**
 *  @author EfeDaniel
 * Link: Ctci Page 90, 1.1
 * Progress: Passed all tried testcases yet
 */
public class IsUnique {

    public static void main(String[] args) {
        System.out.println(isUnique("efe"));
        System.out.println(isUnique("daniel"));
        System.out.println(isUnique(""));
    }

    // Solution 1
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static boolean isUnique(String input) {
        boolean[] charFound = new boolean[128];
        for (char c : input.toCharArray()) {
            if (charFound[c]) return false;
            charFound[c] = true;
        }
        return true;
    }

}
