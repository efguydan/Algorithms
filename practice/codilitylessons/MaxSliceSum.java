package practice.codilitylessons;

public class MaxSliceSum {

    public static void main(String[] args) {
        int[] a = {3, 2, -6, 4, 0};
        System.out.println(solution(a));

        int[] b = {-2, 1};
        System.out.println(solution(b));
    }

    private static int solution(int[] a) {

        int absoluteMax = a[0];
        int localMax = a[0];
        int nextSum = 0;
        int currentElement = 0;

        for (int i = 1; i < a.length; i++) {
            currentElement = a[i];
            nextSum = localMax + currentElement;
            localMax = Math.max(a[i], nextSum);
            absoluteMax = Math.max(absoluteMax, localMax);
        }
        return absoluteMax;
    }

}
