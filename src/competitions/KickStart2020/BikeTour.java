package competitions.KickStart2020;

import java.util.Scanner;

public class BikeTour {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int checkPoints = input.nextInt();
            int[] arr = new int[checkPoints];
            for (int i = 0; i < checkPoints; i++) arr[i] = input.nextInt();
            System.out.println(String.format("Case #%d: %d", ks, solve(arr)));
        }
    }

    private static int solve(int[] arr) {
        int answer = 0;
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) answer++;
        }
        return answer;
    }

}
