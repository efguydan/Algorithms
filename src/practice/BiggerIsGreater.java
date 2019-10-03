package practice;

import java.util.Arrays;

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/bigger-is-greater/problem
 * Progress: Done
 */

public class BiggerIsGreater {

    public static void main(String[] args) {
        System.out.print(biggerIsGreater("ab") + "  ");
        System.out.println(biggerIsGreater("ab").equals("ba") ? "Correct" : "Incorrect");

        System.out.print(biggerIsGreater("bb") + "  ");
        System.out.println(biggerIsGreater("bb").equals("no answer") ? "Correct" : "Incorrect");

        System.out.print(biggerIsGreater("hefg") + "  ");
        System.out.println(biggerIsGreater("hefg").equals("hegf") ? "Correct" : "Incorrect");

        System.out.print(biggerIsGreater("dhck") + "  ");
        System.out.println(biggerIsGreater("dhck").equals("dhkc") ? "Correct" : "Incorrect");

        System.out.print(biggerIsGreater("dkhc") + "  ");
        System.out.println(biggerIsGreater("dkhc").equals("hcdk") ? "Correct" : "Incorrect");
    }

    static String biggerIsGreater(String w) {

        String startString = w;
        int endIndex = w.length() - 1;
        w.toLowerCase();
        int positionToStart = -17;
        String toKeep = "";
        String toRearrange = "";

        for (int i = endIndex; i > 0; i--) {
            if (getPosition(w.charAt(i - 1)) < getPosition(w.charAt(i))) {
                positionToStart = i - 1;
                toRearrange = w.substring(positionToStart, endIndex + 1);
                toKeep = w.substring(0, positionToStart);
                break;
            }
        }

        if (positionToStart != -17) {
            toRearrange = reArrange(toRearrange);
        }

        w = toKeep + toRearrange;

        if (startString.equals(w) || w.length() != startString.length()) {
            return "no answer";
        }

        return w;
    }

    private static String reArrange(String word) {
        String nextBiggestLetter = String.valueOf(getNextBiggestLetter(word));
        word = word.replaceFirst(nextBiggestLetter, "");
        word = sortString(word);
        word = nextBiggestLetter + word;
        return word;
    }

    private static String sortString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    private static char getNextBiggestLetter(String word) {
        int positionOfFirstLetter = getPosition(word.charAt(0));
        int smallest = getPosition(word.charAt(1));
        for (int i = 1; i < word.length(); i++) {
            if (getPosition(word.charAt(i)) > positionOfFirstLetter) {
                smallest = getPosition(word.charAt(i)) < smallest ? getPosition(word.charAt(i)) : smallest;
            }
        }
        return getCharAt(smallest);
    }

    static int getPosition(char alphabet) {
        int pos = alphabet - 'a' + 1;
        return pos;
    }

    static char getCharAt(int position) {
        return (char) (position + 'a' - 1);
    }
}
