package practice.codilitylessons.fibonaccinumbers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/13-fibonacci_numbers/ladder/
 * Progress: Done
 */
public class FibFrog {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,0,0,1,1,0,1,0,0,0,0}));
        System.out.println(solution(new int[]{1}));
        System.out.println(solution(new int[]{1,1,0,0,0}));
    }

    public static int solution(int[] a) {
        List<Integer> fibList = getFibArray(a.length);
        Collections.reverse(fibList);
        List<Point> queue = new ArrayList<>();
        queue.add(new Point(-1, 0));
        int index = 0;
        while (true) {
            if (index == queue.size()) return -1;
            Point current = queue.get(index);

            for (int n : fibList) {
                int nextPosition = current.x + n;

                if (nextPosition == a.length) return ++current.y;

                if (nextPosition > a.length || nextPosition < 0 || a[nextPosition] == 0) continue;

                Point temp = new Point(nextPosition, current.y + 1);
                queue.add(temp);
                a[nextPosition] = 0;
            }

            index++;
        }
    }

    private static List<Integer> getFibArray(int n) {
        List<Integer> fibList = new ArrayList<>();
        fibList.add(0);
        fibList.add(1);
        int current = fibList.get(0) + fibList.get(1);
        while (current <= n+1) {
            fibList.add(current);
            current = fibList.get(fibList.size() - 1) + fibList.get(fibList.size()-2);
        }
        return fibList;
    }

}
