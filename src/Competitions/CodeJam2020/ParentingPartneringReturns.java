package Competitions.CodeJam2020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ParentingPartneringReturns {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int n = input.nextInt();
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(i, input.nextInt(), input.nextInt());
            }
            System.out.println(String.format("Case #%d: %s", ks, solve(n, pairs)));
        }
    }

    private static String solve(int n, Pair[] pairs) {
        Pair.customSort(pairs);
        int c = -1, j = -1;
        String answer = "";
        for (int i = 0; i < n; i++) {
            Pair pair = pairs[i];
            c = endTask(c, pair);
            j = endTask(j, pair);

            if (c < 0) {
                //Assign Task to C
                c = pair.y;
                pair.assign = "C";
            } else if (j < 0) {
                //Assign Task to J
                j = pair.y;
                pair.assign = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        Pair.sortWithID(pairs);
        for (int i = 0; i < n; i++) answer += pairs[i].assign;
        return answer;
    }

    private static int endTask(int person, Pair task) {
        if (person <= task.x) return -1; else return person;
    }

}

class Pair {
    int id;
    int x;
    int y;
    String assign;
    Pair (int id, int x, int y) { this.id = id; this.x = x; this.y = y; }

    @Override
    public String toString() {
        return "[" + id + ": " + x + ", " + y + "]";
    }

    static void customSort(Pair[] pairs) {
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            } else {
                return o1.y - o2.y;
            }
        });
    }

    static void sortWithID(Pair[] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o.id));
    }
}