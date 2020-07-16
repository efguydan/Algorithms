package practice.codilitylessons.prefixsums;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 * Progress: Done
 */
public class CountDiv {

    public static void main(String[] args) {
        System.out.println(solution(6, 11, 4));
    }

    public static int solution(int A, int B, int K) {
        int rem = A % K;
        if (rem != 0) A += K - rem;
        if (A > B) return 0;
        return 1 + (B - A) / K;
    }

}
