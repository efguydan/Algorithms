package practice.interviewcake.arrayandstringmanipulation;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/cafe-order-checker?course=fc1&section=array-and-string-manipulation
 * Progress: Done
 */
public class CafeOrderChecker {

    public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {
        if (takeOutOrders.length + dineInOrders.length != servedOrders.length) return false;

        int takeOutIndex = 0;
        for (int i = 0; i < servedOrders.length; i++) {
            if (takeOutIndex >= takeOutOrders.length) break;
            if (servedOrders[i] == takeOutOrders[takeOutIndex]) takeOutIndex++;
        }

        if (takeOutIndex < takeOutOrders.length) return false;

        int dineInIndex = 0;
        for (int i = 0; i < servedOrders.length; i++) {
            if (dineInIndex >= dineInOrders.length) break;
            if (servedOrders[i] == dineInOrders[dineInIndex]) dineInIndex++;
        }

        if (dineInIndex < dineInOrders.length) return false;

        return true;
    }

}
