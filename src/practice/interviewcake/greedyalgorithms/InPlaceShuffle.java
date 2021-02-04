package practice.interviewcake.greedyalgorithms;

import java.util.Random;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/shuffle?course=fc1&section=greedy
 * Progress: Done
 */
public class InPlaceShuffle {

    private static Random rand = new Random();
    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    public static void shuffle(int[] array) {
        if (array.length < 2) return;
        for (int i = 0; i < array.length - 1; i++) {
            int randomIndex = getRandom(i, array.length - 1);
            if (randomIndex != i) {
                int temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }
        }
    }

}
