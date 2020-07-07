package Competitions.Codejam2019;

public class Solution {
    static int solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            if (A[i] == Y)
                nY += 1;
            if (nX == nY)
                result = i;
        }
        return result;
    }

    static int[] solution2(int N) {
        int[] answer = new int[N];

        for (int i = 0; i < N / 2; i++) {
            answer[i] = i + 1;
            answer[N - 1 - i] = -1 * (i + 1);
        }
        return answer;
    }
}