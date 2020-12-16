package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/add-two-numbers/
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Progress: Done
 */

object AddTwoNumbers {

    /**
     * ListNode Class Definition
     */
    class ListNode(var `val`: Int) { var next: ListNode? = null }

    /** Recursive Solution that builds a new linked list for the answer, hence the O(n) space complexity.
     *  It takes the two relative numbers, when available, from the problem linked lists, adds them,
     *  takes away overflow, if any, and adds that to the solution linked list. It then calls the method recursively
     *  with the next element in both linked lists.
     *
     *  It stops the recursion when both linked lists are at a null solution; albeit not before it takes care
     *  of any remaining overflow available
     *
     */

    private var head: ListNode? = null
    private var current: ListNode? = null

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, overflow: Int = 0): ListNode? {

        // Check if both linked lists are empty
        if (l1 == null && l2 == null) {
            // Takes care of remaining overflow before returning head
            if (overflow > 0) addNode(overflow)
            return head
        }

        //Add the two current nodes values, also taking care of the overflow
        val temp = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + overflow
        addNode(if (temp > 9) temp - 10 else temp)
        addTwoNumbers(l1?.next, l2?.next, if (temp > 9) 1 else 0)
        return head
    }

    /**
     * Appends a node to the linked list or starts a new linked list
     */
    fun addNode(value: Int) {
        if (head == null) {
            head = ListNode(value)
            current = head
        } else {
            current?.next = ListNode(value)
            current = current?.next
        }
    }

}