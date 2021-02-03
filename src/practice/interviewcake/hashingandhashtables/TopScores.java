package practice.interviewcake.hashingandhashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/top-scores?course=fc1&section=hashing-and-hash-tables
 * Progress: Done
 */
public class TopScores {

    public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int score: unorderedScores) {
            int current = map.getOrDefault(score, 0);
            current++;
            map.put(score, current);
        }

        int arrayIndex = 0;
        for (int i = highestPossibleScore-1; i >= 0; i--) {
            int count = map.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                unorderedScores[arrayIndex] = i;
                arrayIndex++;
            }

            if (arrayIndex >= unorderedScores.length) break;
        }

        return unorderedScores;
    }

}
