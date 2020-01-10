package practice;

import java.util.HashMap;
import java.util.Scanner;

class MiscClass {

    public static void main(String[] args) {
        int homerAge = Integer.MIN_VALUE;
        changeHomer(homerAge);
        System.out.println(homerAge);
    }

    private static void changeHomer(int homerAge) {
        homerAge = 35;
    }
}