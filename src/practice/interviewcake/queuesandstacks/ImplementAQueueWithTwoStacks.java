package practice.interviewcake.queuesandstacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/queue-two-stacks?course=fc1&section=queues-stacks
 * Progress: Done
 */
public class ImplementAQueueWithTwoStacks {

    public static class QueueTwoStacks {

        private Deque<Integer> inStack = new ArrayDeque<>();
        private Deque<Integer> outStack = new ArrayDeque<>();

        public void enqueue(int item) {
            inStack.push(item);
        }

        public int dequeue() {
            if (outStack.isEmpty()) {

                while (!inStack.isEmpty()) {
                    int newestInStackItem = inStack.pop();
                    outStack.push(newestInStackItem);
                }

                if (outStack.isEmpty()) {
                    throw new NoSuchElementException("Can't dequeue from empty queue!");
                }
            }
            return outStack.pop();
        }
    }

}
