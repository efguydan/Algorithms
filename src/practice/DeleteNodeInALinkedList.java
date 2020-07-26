package practice;

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/delete-node-in-a-linked-list
 * Progress: Done
 */


public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
