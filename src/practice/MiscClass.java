package practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MiscClass {

    public static void main(String[] args) {
    }

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        Set<Integer> keys = new HashSet<>();
        Set<String> answer = new HashSet<>();

        for (int num: stocksProfit) {
            int counterpart = (int) (target - num);
            if (keys.contains(counterpart)) {
                answer.add(getKey(num, counterpart));
            } else {
                keys.add(num);
            }
        }

        return answer.size();
    }

    private static String getKey(int a, int b) {
        return a + "-" + b;
    }

}