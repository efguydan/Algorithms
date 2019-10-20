package Competitions.IeeeXtreme2019;

import java.util.HashMap;
import java.util.Scanner;

public class XrandaAndTrees {

    int toPick = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfNodes = in.nextInt();
        HashMap<String, Integer> dist = new HashMap<>();
        for (int i = 0; i < noOfNodes-1; i++) {
            String from = in.next();
            String to = in.next();
            int x = in.nextInt();
            dist.put(from+to, x);
        }
        System.out.println(solve(noOfNodes, dist));
    }

    private static int solve(int noOfNodes, HashMap<String, Integer> dist) {
        int answer = 0;
        for (int i = 1; i < noOfNodes-1; i++) {
            for (int j = i+1; j < noOfNodes; j++) {
                answer += getDistFromHashmap(dist, i, j);
            }
        }
        return answer;
    }

    private static int getDistFromHashmap(HashMap<String, Integer> dist, int i, int j) {
        if (dist.containsKey(String.format("%d%d", i, j))) {
            return dist.get(String.format("%d%d", i, j));
        } else {
            dps(dist, String.valueOf(i), String.valueOf(j));
        }
        return 0;
    }

    private static void dps(HashMap<String, Integer> dist, String i, String j) {

    }
}
