package practice.codilitylessons;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
 * Progress: Done
 */
public class MinPerimeterRectangle {

    public static void main(String[] args) {
        System.out.println(solution(30));
    }

    public static int solution(int n) {
        int i = ((Double) Math.sqrt(n)).intValue();
        while (n % i != 0) i--;
        return 2 * (i + n / i);
    }

}
