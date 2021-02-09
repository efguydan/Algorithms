package practice.interviewcake.recursion;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/coin?course=fc1&section=dynamic-programming-recursion
 * Progress: Done
 */
public class MakingChange {

    public static void main(String[] args) {
        final int actual = changePossibilities(4, new int[] {1, 2, 3});
        final int expected = 4;
        System.out.println(actual);
    }

    public static int changePossibilities(int amount, int[] denominations) {
        int[] changeArr = new int[amount+1];
        changeArr[0] = 1;

        for (int coin : denominations) {
            for (int i = coin; i <= amount; i++) {
                changeArr[i] += changeArr[i - coin];
            }
        }

        return changeArr[amount];
    }

}
