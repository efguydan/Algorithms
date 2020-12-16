package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/problem
 * Time Complexity: O(M+N)
 * Space Complexity: O(1)
 * Progress: Done
 */
object MergeTwoSortedLists {

    /**
     * ListNode Class Definition
     */
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Main method Used mainly for testing purposes. Tests the input case:
     * l1 = [1, 2, 4]
     * l1 = [1, 3, 4]
     * output = [1, 1, 2, 3, 4, 4]
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val l1 = ListNode(1).also { one ->
            one.next = ListNode(2).also { two ->
                two.next = ListNode(4)
            }
        }
        val l2 = ListNode(1).also { one ->
            one.next = ListNode(3).also { two ->
                two.next = ListNode(4)
            }
        }

        var answer = mergeTwoLists(l1, l2)
        while (answer != null) {
            print("${answer.`val`} -> ")
            answer = answer.next
        }
    }

    /**
     * Solution Method
     * Starts by verifying both input linked lists aren't empty. It returns the other in the case when one is empty.
     * It then makes sure h1's head is not higher than h2's head. it swaps both linked lists if that isnt the case
     * It also keeps a reference to h1's head, to return at the end of all operations.
     * It then loops through h2 and tries to get the nearest spot in h1 it can insert each value in.
     * As each linked list is sorted, it always keeps the last h1 index it inserted in. therefore making this a
     * linear solution
     */

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var h1 = l1 ?: return l2
        var h2 = l2 ?: return l1

        if (h1.`val` > h2.`val`) { h1 = h2.also { h2 = h1 } }
        val originalH1 = h1

        while (true) {
            while (h1.next != null && h1.next!!.`val` < h2.`val`) h1 = h1.next!!
            val temp = h2.next
            h1.insertImmediate(h2)
            h2 = temp ?: return originalH1
        }
    }

    /**
     * Helper ListNode method to insert a node between a linked list. Just after the node it is supplied.
     */
    private fun ListNode.insertImmediate(other: ListNode) {
        next = other.also { other.next = next }
    }

}