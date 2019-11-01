package practice;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int currentCount = 0, max = 0;
        int i = 0;
        int lastStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                int temp = map.get(s.charAt(i));
                for (int j = lastStart; j <= temp; j++) {
                    map.remove(s.charAt(j));
                    currentCount--;
                    lastStart = j + 1;
                }
                map.put(s.charAt(i), i);
                currentCount++;
            } else {
                map.put(s.charAt(i), i);
                currentCount++;
            }
            i++;
            if (currentCount > max) max = currentCount;
        }
        return max;
    }
}
