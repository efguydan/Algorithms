package competitions.IeeeXtreme2019;

import java.util.*;

public class MinimumPermutation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arraySize = in.nextInt();
        int setSize = in.nextInt();

        int [] list = new int[arraySize];
        int [] set = new int[setSize];

        for (int i = 0; i < arraySize; i++) {
            list[i] = in.nextInt();
        }

        for (int i = 0; i < setSize; i++) {
            set[i] = in.nextInt();
        }
        Arrays.sort(set);

        ArrayList<Integer> answer = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list.length && j < set.length) {
            if (list[i] < set[j]) {
                answer.add(list[i]);
                i++;
            } else {
                answer.add(set[j]);
                j++;
            }
        }
        while(i < list.length) {
            answer.add(list[i]);
            i++;
        }
        while(j < set.length) {
            answer.add(set[j]);
            j++;
        }

        for (int k = 0; k < answer.size(); k++) {
            if (k == 0) System.out.print(answer.get(k));
            else System.out.print(" " + answer.get(k));
        }
    }

}
