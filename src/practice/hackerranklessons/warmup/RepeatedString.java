package practice.hackerranklessons.warmup;

/**
 * @author EfeDaniel
 * Link: www.hackerrank.com/challenges/repeated-string/problem
 * Progress: Done
 */
public class RepeatedString {

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));
    }

    static long repeatedString(String s, long n) {
        long answer = 0;
        long noA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') noA++;
        }
        answer += noA * (n / s.length());
        int toReach = (int) (n % s.length());
        for (int i = 0; i < toReach; i++) {
            if (s.charAt(i) == 'a') answer++;
        }
        return answer;
    }

}
