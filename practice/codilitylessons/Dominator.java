package practice.codilitylessons;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/8-leader/dominator/
 * Progress: Done
 */
public class Dominator {

    public static void main(String[] args) {
        int[] a = {3,4,3,2,3,-1,3,3};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int value = -1;
        int size = 0;
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (size == 0) {
                index = i;
                value = a[i];
                size++;
            } else if (a[i] == value) {
                size++;
            } else if (a[i] != value) {
                size--;
            }
        }
        size = 0;
        for (int i : a) if (i == value) size++;
        return size > a.length / 2 ? index : -1;
    }

}
