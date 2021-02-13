package practice.interviewcake.linkedlists;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/reverse-linked-list?course=fc1&section=linked-lists
 * Progress: Done
 */
public class ReverseALinkedList {

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode reverse(LinkedListNode headOfList) {
        LinkedListNode current = headOfList;
        LinkedListNode prev = null;
        LinkedListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

}
