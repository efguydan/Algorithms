package practice;

import java.util.*;

public class MiscClass {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(5);

        System.out.println(hackerCards(list, 7));
    }

    public static List<Integer> hackerCards(List<Integer> collection, int d) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> coll = new HashSet<>(collection);

        int i = 1;
        while (d > 0 && d > i) {
            if (!coll.contains(i)) {
                answer.add(i);
                d -= i;
            }
            i++;
        }

        return answer;
    }

}