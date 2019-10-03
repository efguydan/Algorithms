package practice;

/**
 * @author EfeDaniel
 * Link:
 * Progress: Done
 */

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(check(15));
        System.out.println(check(10));
        System.out.println(check(9));
        System.out.println(check(1));
    }

    public static String check(int num) {
        String answer = "";
        if (num % 3 == 0)
            answer += "Fizz";
        if (num % 5 == 0)
            answer += "Buzz";
        return answer;
    }
}
