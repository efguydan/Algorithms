package practice

/**
 * @author EfeDaniel
 * Link: leetcode.com/problems/linked-list-cycle/
 * Progress: Done
 */
class LinkedListCycle {

    companion object {
        fun hasCycle(head: ListNode?): Boolean {
            if (head == null) return false
            var tortoise = head
            var hare = head

            do {
                tortoise = tortoise?.next
                hare = hare?.next?.next
            } while (tortoise != hare && hare != null)

            return hare != null
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

}