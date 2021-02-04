package practice.interviewcake.greedyalgorithms;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/highest-product-of-3?course=fc1&section=greedy
 * Progress: Done
 */
public class HighestProductOf3 {

    public static int highestProductOf3(int[] intArray) {
        Arrays.sort(intArray);
        int lastIndex = intArray.length - 1;
        int first = intArray[0] * intArray[1] * intArray[lastIndex];
        int second = intArray[lastIndex-2] * intArray[lastIndex-1] * intArray[lastIndex];
        return Math.max(first, second);
    }

}
