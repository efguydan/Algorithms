package Practice;

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/zigzag-conversion/
 * Progress: Done
 */

public class ZigZagCoversion {

    public static String getWhatToPrint(String s, int numRows, String answer) {
        String gottenAnswer = convert(s, numRows);
        return String.format("%s %b", gottenAnswer, gottenAnswer.equals(answer));
    }

    public static void main(String[] args) {
        System.out.println(getWhatToPrint("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"));
        System.out.println(getWhatToPrint("PAYPALISHIRING", 4, "PINALSIGYAHRPI"));
        System.out.println(getWhatToPrint("A", 1, "A"));
        System.out.println(getWhatToPrint("AB", 1, "AB"));
    }

    public static String convert(String s, int numRows) {
        StringBuilder answer = new StringBuilder();
        int index, firstNumberOfIndexJumps, secondNumberOfIndexJumps;
        boolean isFirstJump;
        if (s.length() <= numRows || numRows == 1)
            return s;
        for (int i = 0; i < numRows; i++) {
            index = i;
            isFirstJump = true;
            firstNumberOfIndexJumps = 2 * (numRows - 1 - i);
            secondNumberOfIndexJumps = 2 * i;
            while (index < s.length()) {
                answer.append(s.charAt(index));
                if (firstNumberOfIndexJumps == 0 || secondNumberOfIndexJumps == 0) {
                    index += firstNumberOfIndexJumps;
                    index += secondNumberOfIndexJumps;
                    continue;
                }
                if (isFirstJump) {
                    index += firstNumberOfIndexJumps;
                } else {
                    index += secondNumberOfIndexJumps;
                }
                isFirstJump = !isFirstJump;
            }
        }
        return answer.toString();
    }
}
