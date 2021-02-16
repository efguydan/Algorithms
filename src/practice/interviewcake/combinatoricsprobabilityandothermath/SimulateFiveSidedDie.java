package practice.interviewcake.combinatoricsprobabilityandothermath;

import java.util.Random;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/simulate-5-sided-die?course=fc1&section=combinatorics-probability-math
 * Progress: Done
 */
public class SimulateFiveSidedDie {

    private static final Random rnd = new Random();

    private static int rand7() {
        return rnd.nextInt(7) + 1;
    }

    public static int rand5() {
        int answer = rand7();
        while (answer > 5) answer = rand7();
        return answer;
    }

}
