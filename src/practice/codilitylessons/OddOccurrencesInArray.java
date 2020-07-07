package practice.codilitylessons;

import java.util.HashMap;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 * Progress: Done
 */
public class OddOccurrencesInArray {

    public int solution(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int current = a[i];
            int temp = 0;
            if (map.containsKey(current)) {
                temp = map.get(current);
            }
            temp++;
            map.put(current, temp);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) % 2 != 0) return key;
        }
        return 0;
    }
}
