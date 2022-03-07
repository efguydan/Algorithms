package competitions.IeeeXtreme2019;

import java.util.*;

public class ConcentrationGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        startGuessing(n);
    }

    private static void startGuessing(int n) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        int n1=0, n2=0;
        ArrayList<Integer> numbersList = new ArrayList();
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 1; i <= 2 * n; i++) {
            numbersList.add(i);
        }
        n1 = numbersList.get(rand.nextInt(numbersList.size()));
        while (n1 == n2 || n2 == 0) n2 = numbersList.get(rand.nextInt(numbersList.size()));
        while (!numbersList.isEmpty()) {
            System.out.println(n1 + " " + n2);
            String input = in.next();
            if (input.equals("MATCH")) {
                numbersList.remove(new Integer(n1));
                numbersList.remove(new Integer(n2));
            } else if (input.equals("-1")) {
                break;
            } else {
                int temp = in.nextInt();
            }
        }
    }

//    private static void startGuessing(int n) {
//        Scanner in = new Scanner(System.in);
//        Random rand = new Random();
//        int n1=0, n2=0, temp = 0;
//        ArrayList<Integer> numbersList = new ArrayList();
//        Map<Integer, Integer> position = new HashMap<>();
//        for (int i = 1; i <= 2 * n; i++) {
//            numbersList.add(i);
//        }
//        n1 = numbersList.get(rand.nextInt(numbersList.size()));
//        while (n1 == n2 || n2 == 0) n2 = numbersList.get(rand.nextInt(numbersList.size()));
//        while(!numbersList.isEmpty()) {
//            System.out.println(n1 + " " + n2);
//            String input = in.next();
//            if (input.equals("MATCH")) {
//                numbersList.remove(new Integer(n1));
//                numbersList.remove(new Integer(n2));
//            }
//            if (input.equals("-1")) break;
//            if (input.equals("MATCH")) {
//                //We just made a match, what next?
//                if (temp != 0) {
//                    n1 = temp;
//                    n2 = position.get(temp);
//                    temp = 0;
//                    position.remove(temp);
//                } else {
//                    n1 = numbersList.get(rand.nextInt(numbersList.size()));
//                    while (n1 == n2) n2 = numbersList.get(rand.nextInt(numbersList.size()));
//                }
//            } else {
//                int inputInt = Integer.parseInt(input);
//                if (position.containsKey(inputInt)) {
//                    n1 = inputInt;
//                    n2 = position.get(inputInt);
//                } else {
//                    position.put(inputInt, n1);
//                    n1 = 0;
//                }
//                int input2 = in.nextInt();
//                if (position.containsKey(input2)) {
//                    if (n1 == 0) {
//                        temp = input2;
//                    } else {
//                        n1 = input2;
//                        n2 = position.get(input2);
//                    }
//                } else {
//                    position.put(input2, n2);
//                    n2 = 0;
//                }
//                if (n1 == 0 && n2 == 0) {
//                    n1 = numbersList.get(rand.nextInt(numbersList.size()));
//                    while (n1 == n2 || n2 == 0) n2 = numbersList.get(rand.nextInt(numbersList.size()));
//                }
//            }
//        }
//    }
}
