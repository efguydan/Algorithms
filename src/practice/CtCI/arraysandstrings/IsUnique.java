package practice.CtCI.arraysandstrings;

/**
 *  @author EfeDaniel
 * Link: Ctci Page 90
 * Progress: Passed all thinkable testcases yet
 */
public class IsUnique {

    public static void main(String[] args) {
        System.out.println(isUnique("efe"));
        System.out.println(isUnique("daniel"));
        System.out.println(isUnique(""));
    }

    // O(n)
    private static boolean isUnique(String input) {
        boolean[] charFound = new boolean[128];
        for (char c : input.toCharArray()) {
            if (charFound[c]) return false;
            charFound[c] = true;
        }
        return true;
    }

}
