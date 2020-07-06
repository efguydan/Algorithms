package practice.CtCI.arraysandstrings;

/**
 *  @author EfeDaniel
 * Link: Ctci Page 91, 1.4
 * Progress: Passed all thinkable testcases yet
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println(palindromePermutation("Tact Coa"));
    }


    // Solution 1
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static boolean palindromePermutation(String input) {
        int[] charFound = new int[128];
        input = input.replaceAll(" ", "").toLowerCase();
        for (char c : input.toCharArray()) charFound[c]++;

        boolean oddFound = false;
        for (int times : charFound) {
            if (!isEven(times)) {
                if (oddFound) return false;
                else oddFound = true;
            }
        }
        return true;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

}
