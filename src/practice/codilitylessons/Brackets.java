package practice.codilitylessons;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));
        System.out.println(solution("([)()]"));
    }

    public static int solution(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(array[i])) {
                stack.push(array[i]);
            } else {
                if (stack.isEmpty() || map.get(stack.pop()) != array[i]) return 0;
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

}
