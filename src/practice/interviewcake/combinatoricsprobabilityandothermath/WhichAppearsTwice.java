package practice.interviewcake.combinatoricsprobabilityandothermath;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/which-appears-twice?course=fc1&section=combinatorics-probability-math
 * Progress: Done
 */
public class WhichAppearsTwice {
    public static int findRepeat(int[] numbers) {
        int sum = 0;
        for (int i: numbers) sum += i;
        int expected = ((numbers.length - 1) * numbers.length) / 2;

        return sum - expected;
    }
}
