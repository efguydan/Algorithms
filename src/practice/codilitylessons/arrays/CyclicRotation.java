package practice.codilitylessons.arrays;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 * Progress: Done
 */
public class CyclicRotation {

    public int[] solution(int[] a, int k) {
        int length = a.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[(i + k) % length] = a[i];
        }
        return answer;
    }
}
