package practice.codilitylessons.maximumsliceproblem;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
 * Progress: Done
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] a = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int maxProfit = 0, min = Integer.MAX_VALUE;
        for (int price : a) {
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }

}
