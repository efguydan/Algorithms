package practice.interviewcake.linkedlists;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/delete-node?course=fc1&section=linked-lists
 * Progress: Done
 */
public class DeleteNode {

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static void deleteNode(LinkedListNode nodeToDelete) {
        if (nodeToDelete.next != null) {
            nodeToDelete.value = nodeToDelete.next.value;
            nodeToDelete.next = nodeToDelete.next.next;
        } else {
            throw new IllegalArgumentException("Can't delete the last node with this technique!");
        }
    }

}
