package practice.interviewcake.hashingandhashtables;

import java.util.HashMap;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/inflight-entertainment?course=fc1&section=hashing-and-hash-tables
 * Progress: Done
 */
public class InflightEntertainment {

    public static void main(String[] args) {
        System.out.println(canTwoMoviesFillFlight(new int[]{3, 8}, 6));
    }

    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {
        HashMap<Integer, Integer> lengths = new HashMap<>();
        for (int movie: movieLengths) {
            int currentCount = lengths.getOrDefault(movie, 0);
            currentCount++;
            lengths.put(movie, currentCount);
        }

        if (flightLength % 2 == 0) {
            if (lengths.getOrDefault(flightLength / 2, 0) > 1) return true;
        }

        for (int i = 0; i <= flightLength/2; i++) {
            if (i == flightLength-i) continue;
            if (lengths.containsKey(i) && lengths.containsKey(flightLength-i)) return true;
        }


        return false;
    }

}
