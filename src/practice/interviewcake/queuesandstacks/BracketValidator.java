package practice.interviewcake.queuesandstacks;

import java.util.*;

public class BracketValidator {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String code) {
        Map<Character, Character> openersToClosers = new HashMap<>();
        openersToClosers.put('(', ')');
        openersToClosers.put('[', ']');
        openersToClosers.put('{', '}');

        char[] arr = code.toCharArray();
        Set<Character> openers = openersToClosers.keySet();
        Set<Character> closers = new HashSet<>(openersToClosers.values());
        Stack<Character> stack = new Stack<>();

        for (char c: arr) {
            if (openers.contains(c)) {
                stack.push(c);
            } else if (closers.contains(c)) {
                if (stack.isEmpty()) return false;
                if (openersToClosers.get(stack.pop()) != c) return false;
            }
        }


        return stack.isEmpty();
    }

}
