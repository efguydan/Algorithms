package practice.CtCI.technicalquestions;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  @author EfeDaniel
 * Link: Ctci Page 68
 * Progress: Done
 */
public class four_cube_sum {
    public static void main(String[] args) {
        fourCubeSum3(1000);
    }

    //Time Complexity = O(n^4)
    public static void fourCubeSum1(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    for (int l = 1; l < n; l++) {
                        if (cubeof(i) + cubeof(j) == cubeof(k) + cubeof(l)) {
                            System.out.println(String.format("%d %d %d %d", i, j, k, l));
                            break;
                        }
                    }
                }
            }
        }
    }

    //Time Complexity = O(n^3)
    public static void fourCubeSum2(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    int l = ((Double) Math.cbrt(cubeof(i) + cubeof(j) - cubeof(k))).intValue();
                    if (cubeof(i) + cubeof(j) == cubeof(k) + cubeof(l)) {
                        System.out.println(String.format("%d %d %d %d", i, j, k, l));
                    }
                }
            }
        }
    }

    //Time Complexity = O(n^2)
    public static void fourCubeSum3(int n) {
        Map<Integer, ArrayList<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int result = cubeof(i) + cubeof(j);
                ArrayList<Pair<Integer, Integer>> list = map.getOrDefault(result, new ArrayList<>());
                list.add(new Pair(i, j));
                map.put(result, list);
            }
        }

        for (int key : map.keySet()) {
            ArrayList<Pair<Integer, Integer>> list = map.get(key);
            for (Pair<Integer, Integer> pair1 : list) {
                for (Pair<Integer, Integer> pair2 : list) {
                    System.out.println(String.format("%d %d %d %d", pair1.getFirst(), pair1.getSecond(), pair2.getFirst(), pair2.getSecond()));
                }
            }
        }
    }

    public static int cubeof(int num) {
        return ((Double) Math.pow(num, 3)).intValue();
    }
}
