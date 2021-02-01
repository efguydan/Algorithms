package practice.interviewcake.arrayandstringmanipulation;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/reverse-string-in-place?course=fc1&section=array-and-string-manipulation
 * Progress: Done
 */
public class StringReverseInPlace {

    public static void reverse(char[] arrayOfChars) {
        int halfLength = arrayOfChars.length / 2;
        for (int i = 0; i < halfLength; i++) {
            char temp = arrayOfChars[i];
            arrayOfChars[i] = arrayOfChars[arrayOfChars.length -1 - i];
            arrayOfChars[arrayOfChars.length - 1 - i] = temp;
        }
    }

}
