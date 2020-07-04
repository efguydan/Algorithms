package practice;

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/palindrome-partitioning-ii/
 * Progress: Not Done
 * Failed : 1/29 Test Cases
 * Time Complexity: O(n**2)
 */

public class PalindromePartitioningII {

    public static void main(String[] args) {
        System.out.print(minCut("aab") + "  ");
        System.out.println(minCut("aab") == 1 ? "Correct" : "Incorrect");

        System.out.print(minCut("adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece") + "  ");
        System.out.println(minCut("adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece") == 273 ? "Correct" : "Incorrect");
    }

    public static int minCut(String s) {
        int smallestFromFront = getSmallestCut(s);
        int smallestFromBack = getSmallestCut(reverseString(s));
        return (smallestFromBack > smallestFromFront) ? smallestFromFront : smallestFromBack;
    }

    private static int getSmallestCut(String word) {
        int numberOfCuts = -1;
        while (word.length() > 0) {
            String currentSubstring = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                if (isPalindrome(word.substring(0, i + 1))) {
                    currentSubstring = word.substring(0, i + 1);
                    break;
                }
            }
            word = word.replaceFirst(currentSubstring, "");
            numberOfCuts++;
        }
        return numberOfCuts;
    }

    private static boolean isPalindrome(String word) {
        if (word.equals(reverseString(word))) {
            return true;
        }
        return false;
    }

    private static String reverseString(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(word);
        stringBuilder = stringBuilder.reverse();
        return stringBuilder.toString();
    }

}
