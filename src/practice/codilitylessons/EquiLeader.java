package practice.codilitylessons;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/8-leader/equi_leader/
 * Progress: Done
 */
public class EquiLeader {

    public static void main(String[] args) {
        int[] a = {4,3,4,4,4,2};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int answer = 0;
        int dominator = getDominator(a);
        if (dominator == -1) return 0;
        int dCount = 0;
        for (int i : a) if (i == dominator) dCount++;

        int met = 0;
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] == dominator) met++;
            if (isDomination(met, i + 1) && isDomination(dCount - met, a.length - i - 1)) answwer++;
        }

        return answer;
    }

    public static boolean isDomination(int count, int size) {
        return count > size / 2;
    }

    public static int getDominator(int[] a) {
        int value = -1;
        int size = 0;
        for (int i = 0; i < a.length; i++) {
            if (size == 0) {
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
        return size > a.length / 2 ? value : -1;
    }

}
