package practice.codilitylessons;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 * Progress: Not Done
 */
public class Flags {

    public static void main(String[] args) {

    }

    public int solution(int[] a) {
        int len = a.length;
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < len - 1; i++) {
            if (a[i] > a[i-1] && a[i] > a[i+1]) peaks.add(i);
        }
        if (peaks.size() < 2) return peaks.size();
        for (int i = peaks.size(); i >= 2; i--) {
            int count = 1;
            int cursorPosition = peaks.get(0);
            for (int j = 1; j < peaks.size(); j++) {
                if (cursorPosition + i <= peaks.get(j)) {
                    cursorPosition = peaks.get(j);
                    count++;
                }
            }
            if (count >= i) return i;
        }
        return 2;
    }

}
