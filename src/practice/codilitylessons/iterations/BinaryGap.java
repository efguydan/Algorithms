package practice.codilitylessons.iterations;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 * Progress: Done
 */
public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(solution(1041));
    }

    public static int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        System.out.println(binaryString);
        int prev = -1, max = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                if (prev < 0) {
                    prev = i;
                    continue;
                }
                int temp = i - prev - 1;
                if (max < temp) max = temp;
                prev = i;
            }
        }
        return max;
    }
}
