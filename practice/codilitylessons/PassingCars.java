package practice.codilitylessons;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 * Progress: Done
 */
public class PassingCars {

    public int solution(int[] a) {
        int n1 = 0, answer = 0;
        for (int i = 0; i < a.length; i++) if (a[i] == 1) n1++;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                answer += n1;
            } else {
                n1--;
            }
            if (answer > 1000000000) return -1;
        }
        return answer;
    }

}
