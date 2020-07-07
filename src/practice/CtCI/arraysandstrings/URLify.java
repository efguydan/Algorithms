package practice.CtCI.arraysandstrings;

/**
 *  @author EfeDaniel
 * Link: Ctci Page 90, 1.3
 * Progress: Passed all thinkable testcases yet
 */
public class URLify {

    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith ", 13));
    }

    // Solution 1
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static String urlify(String input, int trueLength) {
        input = input.trim();
        return input.replaceAll(" ", "%20");
    }

}
