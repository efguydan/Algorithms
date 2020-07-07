package Competitions.IeeeXtreme2019;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BatchmanAndGCD {

    static Set<Integer> gcdSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int [] arr = new int[a];
        for(int i = 0; i < a; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i<a-1; i++) {
            for (int j = 0; j < a; j++) {
                gcdSet.add(getGCD(arr[i], arr[j]));
            }
        }
        for (int i:arr) gcdSet.add(i);
        System.out.println(gcdSet.size());
    }

    public static int getGCD(int firstNum, int secondNum) {
        int largerNumber = firstNum > secondNum ? firstNum : secondNum;
        int smallerNumber = firstNum > secondNum ? secondNum : firstNum;
        while (smallerNumber > 0) {
            int temp = smallerNumber;
            smallerNumber = largerNumber % smallerNumber;
            largerNumber = temp;
        }
        return largerNumber;
    }
}
