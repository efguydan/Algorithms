package practice.interviewcake.greedyalgorithms;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/product-of-other-numbers?course=fc1&section=greedy
 * Progress: Done
 */
public class ProductOfAllOtherNumbers {

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {
        if (intArray.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }
        int[] answer = new int[intArray.length];

        int pre = 1;
        for (int i = 0; i < intArray.length; i++) {
            answer[i] = pre;
            pre *= intArray[i];
        }

        int suf = 1;
        for (int i = intArray.length-1; i >= 0; i--) {
            answer[i] = answer[i] * suf;
            suf *= intArray[i];
        }

        return answer;
    }

}
