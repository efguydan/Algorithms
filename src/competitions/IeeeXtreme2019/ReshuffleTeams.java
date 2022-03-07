package competitions.IeeeXtreme2019;

import java.util.*;

public class ReshuffleTeams {

    private static HashMap<Character, ArrayList<Integer>> lookup = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            String input = in.next();
            System.out.println(solve(input));
        }
    }

    private static int solve(String input) {
        lookup.clear();
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            if (!lookup.containsKey(a)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                lookup.put(a, list);
            } else {
                ArrayList<Integer> list = lookup.get(a);
                if (i > 0 && a == input.charAt(i - 1)) {
                    list.set(list.size() - 1, list.get(list.size()-1) + 1);
                } else {
                    list.add(1);
                }
            }
        }
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            ArrayList<Integer> list = lookup.get(input.charAt(0));
            int newVal = list.get(0) + list.get(list.size() - 1);
            list.set(0, newVal);
            list.remove(list.size() - 1);
        }
        int answer = 0;
        for (Character character : lookup.keySet()) {
            ArrayList<Integer> list = lookup.get(character);
            if (list.size() > 1){
                list.remove(Collections.max(list));
                for (int i: list) answer += i;
            }
        }
        return answer;
    }
}
