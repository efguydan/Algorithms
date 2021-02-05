package practice.interviewcake.sortingsearchindandlogarithms;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/find-rotation-point?course=fc1&section=sorting-searching-logarithms
 * Progress: Done
 */
public class FindRotationPoint {

    public static int findRotationPoint(String[] words) {
        String firstWord = words[0];
        int start = 0, end = words.length-1;
        while(start + 1 < end) {
            int mid = (start + end) / 2;

            if (words[mid].compareTo(firstWord) >= 0) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }

}
