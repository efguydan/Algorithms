package practice;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

class MiscClass {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Random random = new Random();
        int a = random.nextInt(60);
        System.out.println(a);

        long finish = System.currentTimeMillis();

        System.out.println(finish - start);
    }
}