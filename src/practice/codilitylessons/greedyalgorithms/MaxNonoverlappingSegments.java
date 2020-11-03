package practice.codilitylessons.greedyalgorithms;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
 * Codility Report Link: https://app.codility.com/demo/results/trainingQHK9WS-QDQ/
 * Progress: Done
 */
public class MaxNonoverlappingSegments {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,7,9,9}, new int[]{5,6,8,9,10}));
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0, curEnd = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > curEnd) {
                answer++;
                curEnd = b[i];
            }
        }
        return answer;
    }

}
