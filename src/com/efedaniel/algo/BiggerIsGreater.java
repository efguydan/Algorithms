package com.efedaniel.algo;

/**
 * 
 * @author EfeDaniel
 * Link: 
 * Progress: In Progress
 *
 */

public class BiggerIsGreater {

	public static void main(String[] args) {
		System.out.print(biggerIsGreater("ab") + "  ");
		System.out.println(biggerIsGreater("ab").equals("ba") ? "Correct" : "Incorrect");
		
		System.out.print(biggerIsGreater("bb") + "  ");
		System.out.println(biggerIsGreater("bb").equals("no answer")  ? "Correct" : "Incorrect");
		
		System.out.print(biggerIsGreater("hefg") + "  ");
		System.out.println(biggerIsGreater("hefg").equals("hegf") ? "Correct" : "Incorrect");
		
		System.out.print(biggerIsGreater("dhck") + "  ");
		System.out.println(biggerIsGreater("dhck").equals("dhkc") ? "Correct" : "Incorrect");
		
		System.out.print(biggerIsGreater("dkhc") + "  ");
		System.out.println(biggerIsGreater("dkhc").equals("hcdk") ? "Correct" : "Incorrect");
	}
	
	static String biggerIsGreater(String w) {

        String startString = w;
        int length = w.length();
        w.toLowerCase();
        int positionToStart = -1;
        for (int i = length-1; i > 0; i--) {
            if (getPosition(w.charAt(i - 1)) > getPosition(w.charAt(i))) {
                continue;
            } else {
                w = swap(w, i, i - 1);
                positionToStart = i;
                break;
            }
        }

        if (positionToStart >= 0) {
            for (int j = positionToStart; j < length - 1; j++) {
                if (getPosition(w.charAt(j)) < getPosition(w.charAt(j + 1))) {
                   w = swap(w, j, j + 1);
                }
            }
        }
        if (startString.equals(w)) {
            return "no answer";
        }
        return w;
    }

    static int getPosition(char alphabet) {
        int pos = alphabet - 'a' + 1;
        return pos;
    }

    static String swap(String word, int pos1, int pos2) {
        String[] wordArray = word.split("");
        String temp = wordArray[pos2];
        wordArray[pos2] = wordArray[pos1];
        wordArray[pos1] = temp;

        String returned = "";
        for (int k = 0; k < wordArray.length; k++) {
            returned = returned + wordArray[k];
        }
        return returned;
    }

}
