package practice;

import java.util.HashMap;
import java.util.Stack;

public class ReverseSentenceWithoutSplit {

    public static void main(String[] args) {
        String sentence = "My, name is Neil.";
        System.out.println(reverseWords(sentence));
    }

    public static String reverseWords(String sentence) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        HashMap<Integer, Character> map = new HashMap<>();
        int words = 0;

        char[] sentenceArray = sentence.toCharArray();

        for (int i = 0; i <= sentenceArray.length; i++) {
            if (i == sentenceArray.length && (sentenceArray[i-1] == ',' || sentenceArray[i-1] == '.')) {
                map.put(words, sentenceArray[i-1]);
                continue;
            }
            if (sentenceArray[i] == ',' || sentenceArray[i] == '.') continue;
            if (sentenceArray[i] == ' ') {
                if (i-1 > 0 && (sentenceArray[i-1] == ',' || sentenceArray[i-1] == '.')) {
                    map.put(words, sentenceArray[i-1]);
                }
                words++;
            }
            stack.push(sentenceArray[i]);
        }

        words = 0;
        Stack<Character> current = new Stack<>();
        while(!stack.isEmpty()) {
            char c = stack.pop();
            if (c == ' ') {
                while (!current.isEmpty()) answer.append(current.pop());
                if (map.containsKey(words)) answer.append(map.get(words));
                answer.append(c);
                words++;
            } else {
                current.push(c);
            }
        }

        while (!current.isEmpty()) answer.append(current.pop());
        if (map.containsKey(words)) answer.append(map.get(words));

        return answer.toString();
    }


}
