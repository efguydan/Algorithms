package practice.interviewcake.linkedlists;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/kth-to-last-node-in-singly-linked-list?course=fc1&section=linked-lists
 * Progress: Done
 */
public class KthToLastNodeInASinglyLinkedList {

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {
        if (k < 1) {
            throw new IllegalArgumentException(
                    "Impossible to find less than first to last node: " + k);
        }

        LinkedListNode current = head;
        LinkedListNode kth = head;

        for (int i = 0; i < k - 1; i++) {
            if (current.next == null) {
                throw new IllegalArgumentException("k is larger than the length of the linked list: " + k);
            }
            current = current.next;
        }

        while (current.next != null) {
            current  = current.next;
            kth = kth.next;
        }

        return kth;
    }

}
