package practice.codilitylessons.primeandcompositenumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/
 * Progress: Not Done
 */
public class Peaks {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int len = a.length;
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < len - 1; i++) {
            if (a[i] > a[i-1] && a[i] > a[i+1]) peaks.add(i);
        }
        for (int i = len - 1; i > 0; i--) {
            if (len % i != 0) continue;
            int bi = -0;
            int block = len / i;
            for (int j : peaks) {
                if (bi * block <= j && j < (bi + 1) * block) bi++;
            }
            if (bi == i) return i;
        }
        return 0;
    }

    // 45% solution
//    public static int solution(int[] a) {
//        List<Integer> peaks = new ArrayList<>();
//        for (int i = 1; i < a.length - 1; i++) {
//            if (a[i] > a[i-1] && a[i] > a[i+1]) peaks.add(i);
//        }
//        int answer = peaks.size();
//        for (int i = answer; i > 0; i++) {
//            int currentListIndex = 0;
//            int partition = a.length / answer, start, end;
//            boolean thisIsIt = true;
//            for (int j = 1; j <= answer; j++) {
//                start = partition * (j-1);
//                end = Math.min(start + partition - 1, a.length - 1);
//
//                while (currentListIndex < peaks.size() && peaks.get(currentListIndex) < start) currentListIndex++;
//                if (currentListIndex >= peaks.size()) {
//                    thisIsIt = false;
//                    break;
//                }
//                if (!(peaks.get(currentListIndex) >= start && peaks.get(currentListIndex) <= end)) {
//                    thisIsIt = false;
//                    break;
//                }
//            }
//            if (thisIsIt) return i;
//        }
//        return answer;
//    }

}
