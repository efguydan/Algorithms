/**
 *
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/roman-to-integer/
 * Progress: Done
 *
 */

public class RomanToInteger {
    public static void main (String[] args) {
        System.out.println("III : " + String.valueOf(romanToInt("III")));
        System.out.println("IV : " + String.valueOf(romanToInt("IV")));
        System.out.println("VI : " + String.valueOf(romanToInt("VI")));
        System.out.println("MCMXCIV : " + String.valueOf(romanToInt("MCMXCIV")));
    }

    public static int romanToInt(String s) {
        String[] split = s.split("");
        int answer = 0;
        for (int i = split.length - 1; i >= 0; i--) {
            int currentValue = getNumberFromRoman(split[i]);
            if (i > 0 && currentValue > getNumberFromRoman(split[i-1])) {
                answer += currentValue - getNumberFromRoman(split[i-1]);
                i--;
            } else {
                answer += getNumberFromRoman(split[i]);
            }
        }
        return answer;
    }

    private static int getNumberFromRoman (String s) {
        switch (s) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            default:
                return 1000;
        }
    }
}
