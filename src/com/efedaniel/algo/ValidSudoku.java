package com.efedaniel.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author EfeDaniel
 * Link: 
 * Progress: Done
 *
 */

public class ValidSudoku {
	public static void main(String [] args) {
		char [][] sudoku1 = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
				};
		System.out.println(isValidSudoku(sudoku1));
		
		char [][] sudoku2 = {
				{'8','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
				};
		System.out.println(isValidSudoku(sudoku2));
		
		char [][] sudoku3 = {
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'}
				};
		System.out.println(isValidSudoku(sudoku3));
	}
	
	public static boolean isValidSudoku(char[][] board) {
		int numberOfNonDots = 0;
		Map<String, String> horizontalset = new HashMap<String, String>();
		Map<String, String> verticalset = new HashMap<String, String>();
		Map<String, String> boxset = new HashMap<String, String>();
		
		String horizontalValue, verticalValue, boxValue;
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(board[i][j] == '.')
					continue;
				numberOfNonDots++;
				
				horizontalValue = String.valueOf(board[i][j]) + String.valueOf(i);
				horizontalset.put(horizontalValue, horizontalValue);
				
				verticalValue = String.valueOf(board[i][j]) + String.valueOf(j);
				verticalset.put(verticalValue, verticalValue);
				
				boxValue = String.valueOf(board[i][j]) + getBoxValue(String.valueOf(board[i][j]), i, j);
				boxset.put(boxValue, boxValue);
			}
		}
		
		if(horizontalset.size() != numberOfNonDots || verticalset.size() != numberOfNonDots || boxset.size() != numberOfNonDots)
			return false;
        return true;
    }
	
	public static String getBoxValue(String value, int i, int j) {
		if(i<3) {
			if(j<3)
				return "1";
			if(j<6)
				return "2";
			return "3";
		}else if(i<6) {
			if(j<3)
				return "4";
			if(j<6)
				return "5";
			return "6";
		}else {
			if(j<3)
				return "7";
			if(j<6)
				return "8";
			return "9";
		}
	}
}
