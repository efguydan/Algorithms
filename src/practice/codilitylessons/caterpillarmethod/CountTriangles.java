package practice.codilitylessons.caterpillarmethod;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/15-caterpillar_method/count_triangles/
 * Codility Report Link: https://app.codility.com/demo/results/training72347M-ZFT/
 * Progress: Done
 */
public class CountTriangles {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {10, 2, 5, 1, 8, 12}));
    }

    public static int solution(int[] a) {
        int answer = 0;
        if (a.length < 3) return answer;
        Arrays.sort(a);

        for (int x = 0; x < a.length; x++) {
            int z = x + 2;
            for (int y = x + 1; y < a.length; y++) {
                while(z < a.length && a[x] + a[y] > a[z]) z++;
                answer += z - y - 1;
            }
        }

        return answer;
    }

}
