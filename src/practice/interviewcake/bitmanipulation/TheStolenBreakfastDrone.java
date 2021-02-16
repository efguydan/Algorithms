package practice.interviewcake.bitmanipulation;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/highest-product-of-3?course=fc1&section=greedy
 * Progress: Done
 */
public class TheStolenBreakfastDrone {

    public static int findUniqueDeliveryId(int[] deliveryIds) {
        int answer = 0;
        for (int id: deliveryIds) answer ^= id;
        return answer;
    }

}
