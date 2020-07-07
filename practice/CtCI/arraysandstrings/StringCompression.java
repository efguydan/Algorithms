package practice.CtCI.arraysandstrings;

/**
 *  @author EfeDaniel
 * Link: Ctci Page 91, 1.6
 * Progress: Passed all thinkable testcases yet
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(stringCompression("aabcccccaaa"));
        System.out.println(stringCompression(""));
        System.out.println(stringCompression("abc"));
    }


    // Solution 1
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static String stringCompression(String input) {
        StringBuilder answer = new StringBuilder();

        char currentChar = ' ';
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != currentChar) {
                addChar(answer, currentChar, count);
                currentChar = c;
                count = 1;
            } else {
                count++;
            }
        }
        addChar(answer, currentChar, count);
        String answerString = answer.toString();

        return answerString.length() >= input.length() ? input : answerString;
    }

    public static void addChar(StringBuilder builder, char c, int count) {
        if (count != 0) {
            builder.append(c);
            builder.append(count);
        }
    }
}
