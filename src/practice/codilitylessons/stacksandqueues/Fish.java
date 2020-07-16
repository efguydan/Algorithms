package practice.codilitylessons.stacksandqueues;

import java.util.Stack;

/**
 *  @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
 * Progress: Done
 */
public class Fish {

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 1, 5};
        int[] b = {0, 1, 0, 0, 0};
        System.out.println(solution(a, b));
    }

    public static int solution(int[] a, int[] b) {
        int answer = a.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 1) stack.push(i); else {
                while (!stack.isEmpty()) {
                    if (a[stack.peek()] > a[i]) {
                        answer--;
                        break;
                    } else {
                        answer--;
                        stack.pop();
                    }
                }
            }

        }
        return answer;
    }

}
