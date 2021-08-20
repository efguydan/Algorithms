package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  @author EfeDaniel
 * Link: https://leetcode.com/problems/swap-nodes-in-pairs/
 * Progress: Done
 */

class SwapNodeInPairs {

    public static ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode tempNode, currentNode, nodeToReturn = head.next;
        currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            tempNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            tempNode.next = currentNode;
            tempNode = currentNode;
            currentNode = currentNode.next;
            if (tempNode.next != null && tempNode.next.next != null) tempNode.next = tempNode.next.next;
        }
        return nodeToReturn == null ? head : nodeToReturn;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
