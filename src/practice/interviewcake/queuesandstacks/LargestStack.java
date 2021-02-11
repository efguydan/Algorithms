package practice.interviewcake.queuesandstacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/largest-stack?course=fc1&section=queues-stacks
 * Progress: Done
 */
public class LargestStack {

    public static class MaxStack {

        private Deque<Integer> stack = new ArrayDeque<>();
        private Deque<Integer> maxesStack = new ArrayDeque<>();

        public void push(int item) {
            stack.push(item);
            if (maxesStack.isEmpty() || item >= maxesStack.peek()) {
                maxesStack.push(item);
            }
        }

        public int pop() {
            int item = stack.pop();
            if (item == maxesStack.peek()) {
                maxesStack.pop();
            }
            return item;
        }

        public int getMax() {
            return maxesStack.peek();
        }
    }

}
