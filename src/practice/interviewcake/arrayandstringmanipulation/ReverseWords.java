package practice.interviewcake.arrayandstringmanipulation;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/reverse-words?course=fc1&section=array-and-string-manipulation
 * Progress: Done
 */
public class ReverseWords {

    public static void reverseWords(char[] message) {
        reverseSingleMessage(message, 0, message.length-1);
        int start = 0;
        for (int i = 0; i <= message.length; i++) {
            if (i == message.length || message[i] == ' ') {
                reverseSingleMessage(message, start, i-1);
                start = i + 1;
            }
        }
    }

    public static void reverseSingleMessage(char[] message, int start, int end){
        while (start < end) {
            char temp = message[start];
            message[start] = message[end];
            message[end] = temp;
            start++;
            end--;
        }
    }

}
