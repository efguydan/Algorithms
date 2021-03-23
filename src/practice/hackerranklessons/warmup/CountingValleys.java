package practice.hackerranklessons.warmup;

/**
 * @author EfeDaniel
 * Link: www.hackerrank.com/challenges/counting-valleys/problem
 * Progress: Done
 */
public class CountingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }

    static int countingValleys(int n, String s) {
        int answer = 0;
        int currentPos = 0;
        boolean canAdd = true;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            currentPos += getValToAdd(array[i]);
            if (currentPos < 0 && canAdd) {
                answer++;
                canAdd = false;
            }
            if (currentPos >= 0) {
                canAdd = true;
            }
        }
        return answer;
    }

    static int getValToAdd(char c) {
        if (c == 'U') return 1; else return -1;
    }

}
