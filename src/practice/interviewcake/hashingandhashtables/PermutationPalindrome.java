package practice.interviewcake.hashingandhashtables;

import java.util.HashSet;
import java.util.Set;

public class PermutationPalindrome {

    public static boolean hasPalindromePermutation(String theString) {

        Set<Character> set = new HashSet<>();
        char[] arr = theString.toCharArray();

        for (char c: arr) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.size() < 2;
    }

}
