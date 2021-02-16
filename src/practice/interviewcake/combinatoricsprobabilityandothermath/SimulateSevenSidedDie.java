package practice.interviewcake.combinatoricsprobabilityandothermath;

import java.util.Random;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/simulate-7-sided-die?course=fc1&section=combinatorics-probability-math
 * Progress: Done
 */
public class SimulateSevenSidedDie {

    private static final Random rnd = new Random();

    private static int rand5() {
        return rnd.nextInt(5) + 1;
    }

    public static int rand7() {
        while (true) {
            int roll1 = rand5();
            int roll2 = rand5();
            int outcomeNumber = (roll1-1) * 5 + (roll2-1) + 1;
            if (outcomeNumber > 21) continue;
            return outcomeNumber % 7 + 1;
        }
    }

}
