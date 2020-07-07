package practice;

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/camelcase/problem
 * Progress: Done
 */
public class CamelCase {

    public static void main(String[] args) {
        System.out.println(camelcase("saveChangesInTheEditor"));
    }

    static int camelcase(String s) {
        int answer = 1;
        char[] arr = s.toCharArray();
        for (char c : arr) if (Character.isUpperCase(c)) answer++;
        return answer;
    }

}
