package practice.interviewcake.queuesandstacks;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/largest-stack?course=fc1&section=queues-stacks
 * Progress: Done
 */
public class ParenthesisMatching {

    public static int getClosingParen(String sentence, int openingParenIndex) {
        char[] arr =  sentence.toCharArray();
        int openParenthesis = 0;

        for (int i = openingParenIndex; i < sentence.length(); i++) {
            if (arr[i] == '(') {
                openParenthesis++;
            } else if (arr[i] == ')') {
                openParenthesis--;
                if (openParenthesis == 0) return i;
            }
        }
        throw new IllegalArgumentException("No valid exception");
    }

}
