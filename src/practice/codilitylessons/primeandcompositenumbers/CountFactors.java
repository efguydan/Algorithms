package practice.codilitylessons.primeandcompositenumbers;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
 * Progress: Done
 */
public class CountFactors {

    public static void main(String[] args) {
        System.out.println(solution(2147483647));
    }

    public static int solution(int n) {
        int answer = 0;
        int i = 1;
        while ((long) i * (long) i < (long) n) {
            if (n % i == 0) answer += 2;
            i++;
        }
        if (i*i == n) answer++;
        return answer;
    }

}
