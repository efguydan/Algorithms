package practice.interviewcake.linkedlists;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/linked-list-cycles?course=fc1&section=linked-lists
 * Progress: Done
 */
public class DoesThisLinkedListHaveACycle {

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode(1);
        node.next = node;
        System.out.println(containsCycle(node));
    }

    public static boolean containsCycle(LinkedListNode firstNode) {
        if (firstNode == null || firstNode.next == null) return false;

        LinkedListNode tortoise = firstNode;
        LinkedListNode hare = firstNode;

        do {
            tortoise = tortoise.next;
            hare = hare.next.next;
        } while (tortoise != hare && hare != null);

        return hare != null;
    }

}
