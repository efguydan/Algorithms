package practice;

import java.util.Scanner;

public class MiscClass {

    public static void main(String[] args) {
        int[] numbers = new int[] {0,1,2,3};
        System.out.println(getDifferentNumber(numbers));
    }

    static int getDifferentNumber(int[] arr) {
        // your code goes here
        int len = arr.length;
        if(arr == null || len == 0) {
            return 0;
        }

        int[] staticArr = new int[len];

        for (int i =0;i<len;i++) {
            staticArr[i] = i;
        }
        boolean temp0 = false;
        for (int i =0; i<len; i++) {
            if(arr[i] ==0) {
                temp0 = true;
            } else if(arr[i] < len) {
                staticArr[i]= -1*staticArr[i];
            }
        }
        if(!temp0) {
            return 0;
        }
        for (int i =1;i<len;i++) {
            if(staticArr[i] > 0) {
                return staticArr[i];
            }
        }
        return len;
    }

}