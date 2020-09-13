package practice;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/word-search/
 * Progress: Done
 */
public class WordSearch {

    private static char[][] board;
    private static char[] wordArray;

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        WordSearch.board = board;
        wordArray = word.toCharArray();
        return findMatch();
    }

    public static boolean findMatch() {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j  = 0; j < board[i].length; j++) {
                if (board[i][j] == wordArray[0]) {
                    Set<String> usedPairs = new HashSet<>(wordArray.length);
                    usedPairs.add(getKey(i, j));
                    result = result || traverse(i, j, 1, usedPairs);
                }
            }
        }
        return result;
    }

    public static boolean traverse(int i, int j, int currentIndex, Set<String> usedPairs) {
        //Do we have the word?
        if (currentIndex >= wordArray.length) return true;

        //Can we move up?
        if (i > 0 && board[i-1][j] == wordArray[currentIndex]) {
            if (usedPairs.add(getKey(i-1, j))) {
                if (traverse(i-1, j, currentIndex+1, usedPairs)) return true;
                usedPairs.remove(getKey(i-1, j));
            }
        }

        //Can we move down?
        if (i < board.length-1 && board[i+1][j] == wordArray[currentIndex]) {
            if (usedPairs.add(getKey(i+1, j))) {
                if (traverse(i+1, j, currentIndex+1, usedPairs)) return true;
                usedPairs.remove(getKey(i+1, j));
            }
        }

        //Can we move right?
        if (j < board[i].length-1 && board[i][j+1] == wordArray[currentIndex]) {
            if (usedPairs.add(getKey(i, j+1))) {
                if (traverse(i, j+1, currentIndex+1, usedPairs)) return true;
                usedPairs.remove(getKey(i, j+1));
            }
        }

        //Can we move left?
        if (j > 0 && board[i][j-1] == wordArray[currentIndex]) {
            if (usedPairs.add(getKey(i, j-1))) {
                if (traverse(i, j-1, currentIndex+1, usedPairs)) return true;
                usedPairs.remove(getKey(i, j-1));
            }
        }

        return false;
    }

    private static String getKey(int i, int j) {
        return i + "-" + j;
    }

}
