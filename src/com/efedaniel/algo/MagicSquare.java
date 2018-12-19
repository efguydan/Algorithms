package com.efedaniel.algo;

/**
 * 
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/magic-square-forming/problem
 * Progress: Done
 *
 */

public class MagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int formingMagicSquare(int[][] s) {

        int [][] magic0 = {{8,1,6},{3,5,7},{4,9,2}};
        int [][] magic1 = {{6,1,8},{7,5,3},{2,9,4}};
        int [][] magic2 = {{4,9,2},{3,5,7},{8,1,6}};
        int [][] magic3 = {{2,9,4},{7,5,3},{6,1,8}};
        int [][] magic4 = {{8,3,4},{1,5,9},{6,7,2}};
        int [][] magic5 = {{4,3,8},{9,5,1},{2,7,6}};
        int [][] magic6 = {{6,7,2},{1,5,9},{8,3,4}};
        int [][] magic7 = {{2,7,6},{9,5,1},{4,3,8}};

        int [] differences = new int[8];
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                differences[0] += Math.abs(magic0[i][j] - s[i][j]);
                differences[1] += Math.abs(magic1[i][j] - s[i][j]);
                differences[2] += Math.abs(magic2[i][j] - s[i][j]);
                differences[3] += Math.abs(magic3[i][j] - s[i][j]);
                differences[4] += Math.abs(magic4[i][j] - s[i][j]);
                differences[5] += Math.abs(magic5[i][j] - s[i][j]);
                differences[6] += Math.abs(magic6[i][j] - s[i][j]);
                differences[7] += Math.abs(magic7[i][j] - s[i][j]);
            }
        }

        int smallest = differences[0];
        for (int k = 0; k < differences.length; k++){
            smallest = (smallest > differences[k]) ? differences[k] : smallest;
        }
        return smallest;
    }

}
