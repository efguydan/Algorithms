package practice.interviewcake.recursion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/recursive-string-permutations?course=fc1&section=dynamic-programming-recursion
 * Progress: Done
 */
public class RecursiveStringPermutations {

    public static Set<String> getPermutations(String inputString) {

        if (inputString.length() <= 1) {
            return new HashSet<>(Collections.singletonList(inputString));
        }

        String rem = inputString.substring(0, inputString.length() - 1);
        char current = inputString.charAt(inputString.length() - 1);

        Set<String> remCombinations = getPermutations(rem);

        Set<String> permutations = new HashSet<>();
        for (String combination : remCombinations) {
            for (int position = 0; position <= rem.length(); position++) {
                String permutation = combination.substring(0, position) + current + combination.substring(position);
                permutations.add(permutation);
            }
        }

        return permutations;
    }

}
