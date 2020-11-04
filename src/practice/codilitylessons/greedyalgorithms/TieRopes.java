package practice.codilitylessons.greedyalgorithms;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/16-greedy_algorithms/tie_ropes/
 * Codility Report Link: https://app.codility.com/demo/results/trainingXGPJQU-D9J/
 * Progress: Done
 */
public class TieRopes {

    public static void main(String[] args) {
        System.out.println(solution(4, new int[] {1,2,3,4,1,1,3}));
    }

    public static int solution(int k, int[] a) {
        int answer = 0, currentSum = 0;

        for (int rope : a) {
            currentSum += rope;
            if (currentSum >= k) {
                answer++;
                currentSum = 0;
            }
        }

        return answer;
    }
}
