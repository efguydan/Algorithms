package practice.codilitylessons;

import java.util.Set;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 * Progress: Done
 */
public class GenomicRangeQuery {

    //Solution 2
    public int[] solution(String input, int[] p, int[] q) {
        int[] answer = new int[p.length];
        int stringLength = input.length();
        int [][] occurrences = new int [stringLength][4];

        for (int i = 0; i < stringLength; i++) {
            switch (input.charAt(i)) {
                case 'A': occurrences[i][0] = 1;
                case 'C': occurrences[i][1] = 1;
                case 'G': occurrences[i][2] = 1;
                case 'T': occurrences[i][3] = 1;
            }
        }

        for (int j = 1; j < stringLength; j++) for (int k = 0; k < 4; k++) occurrences[j][k] += occurrences[j-1][k];

        for (int l = 0; l < p.length; l++) {
            int index1 = p[l], index2 = q[l];
            for (int m = 0; m < 4; m++) {
                int lowerCount = 0;
                if (index1 - 1 >= 0) lowerCount = occurrences[index1-1][m];
                if (occurrences[index2][m] - lowerCount > 0) {
                    answer[l] = m + 1;
                    break;
                }
            }
        }

        return answer;
    }

    //Solution 1

//    String[] individuals = new String[]{"A", "C", "G", "T"};
//
//    public int[] solution(String input, int[] p, int[] q) {
//        int[] answer = new int[p.length];
//        for (int i = 0; i < p.length; i++) {
//            String temp = input.substring(p[i], q[i] + 1);
//            for (int j = 0; j < individuals.length; j++) {
//                if (temp.contains(individuals[j])) {
//                    answer[i] = map(individuals[j].charAt(0));
//                    break;
//                }
//            }
//        }
//        return answer;
//    }
//
//    private int map(char c) {
//        switch (c) {
//            case 'A':
//                return 1;
//            case 'C':
//                return 2;
//            case 'G':
//                return 3;
//            default:
//                return 4;
//        }
//    }
}
