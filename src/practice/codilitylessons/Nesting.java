package practice.codilitylessons;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
 * Progress: Done
 */
public class Nesting {

    public static void main(String[] args) {
        System.out.println(solution("()(()()(((()())(()()))"));
    }

    public static int solution(String s) {
        int answer = 0;
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            answer += getNumber(charArray[i]);
            if (answer < 0) return 0;
        }
        return answer > 0 ? 0 : 1;
    }

    public static int getNumber(char c) {
        return c == '(' ? 1 : -1;
    }
}
