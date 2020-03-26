package practice.codilitylessons;

import java.util.*;

public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 1}));
        System.out.println(solution(new int[] {1, 5, 2, 1, 4, 0}));
    }

    public static int solution(int[] a) {
        Set<String> answer = new HashSet<>();
        Map<Integer, ArrayList<Integer>> indexMap = new HashMap<>();

        Pair[] pairs = new Pair[a.length];
        for (int i = 0; i < a.length; i++) {
            pairs[i] = new Pair(a[i], i);
        }
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            } else {
                return o1.y - o2.y;
            }
        });

        for (Pair p : pairs) {
            int start = p.y - p.x, end = p.y + p.x;
            for (int i = start; i <=end; i++) {
                ArrayList<Integer> currentList = null;
                if (indexMap.containsKey(i)) currentList = indexMap.get(i); else currentList = new ArrayList<>();
                for (int index : currentList) {
                    answer.add(String.format("%d-%d", Math.min(p.y, index), Math.max(p.y, index)));
                }
                currentList.add(p.y);
                indexMap.put(i, currentList);
            }
        }

        return answer.size();
    }

    static class Pair {
        int x;
        int y;
        Pair (int x, int y) { this.x = x; this.y = y; }
    }
}
