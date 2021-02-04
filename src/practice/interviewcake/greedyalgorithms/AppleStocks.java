package practice.interviewcake.greedyalgorithms;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/merge-sorted-arrays?course=fc1&section=array-and-string-manipulation
 * Progress: Done
 */
public class AppleStocks {

    public static int getMaxProfit(int[] stockPrices) {

        if (stockPrices.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

        int answer = Integer.MIN_VALUE;
        int currentMin = Integer.MAX_VALUE;
        for (int price: stockPrices) {
            answer = Math.max(answer, price - currentMin);
            currentMin = Math.min(currentMin, price);
        }

        return answer;
    }

}
