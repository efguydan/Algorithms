package practice.codilitylessons;

import java.util.Stack;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
 * Progress: Done
 */
public class StoneWall {
    public static void main(String[] args) {
        int[] a = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        System.out.println(solution(a));
    }

    public static int solution(int[] h) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < h.length; i++) {
            if (stack.isEmpty()) {
                stack.push(h[i]);
                answer++;
            } else {
                int current = h[i];
                if (stack.peek() > current) {
                    while (!stack.isEmpty() && stack.peek() > current) {
                        stack.pop();
                    }
                    if (stack.isEmpty() || stack.peek() != current) {
                        stack.push(current);
                        answer++;
                    }
                } else if (stack.peek() < current) {
                    stack.push(current);
                    answer++;
                }
            }
        }
        return answer;
    }
}
