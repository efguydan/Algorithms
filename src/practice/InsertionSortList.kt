package practice

/**
 *  @author EfeDaniel
 * Link: https://leetcode.com/problems/insertion-sort-list/
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * Progress: Done
 */
object InsertionSortList {

    /**
     * ListNode Class Definition
     */
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Main method Used mainly for testing purposes. Tests the input case:
     * l1 = [-1, 5, 3, 4, 0]
     * output = [-1, 0, 3, 4, 5]
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val list = ListNode(-1).also { one ->
            one.next = ListNode(5).also { two ->
                two.next = ListNode(3).also { three ->
                    three.next = ListNode(4).also { four ->
                        four.next = ListNode(0)
                    }
                }
            }
        }

        var answer = insertionSortList(list)
        while (answer != null) {
            print("${answer.`val`} -> ")
            answer = answer.next
        }
    }

    /**
     * Solution method. Implements Insertion Sort for a linked list. Takes each element and inserts it into the
     * correct position. The correct position is found by going back to the head of the linked list and searching
     * from there.
     */
    fun insertionSortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        var head = head
        var current = head.next
        var prev = head
        var max = head.`val`

        while (current != null) {
            if (current.`val` < max) {
                prev?.next = current.next
                current.next = null;
                head = insertIntoCorrectPosition(current, head)
                current = prev?.next
            } else {
                max = current.`val`
                prev = current
                current = current.next
            }
        }

        return head
    }

    /**
     * Helper method to insert a node into a linked list at the correct sorted position.
     */
    private fun insertIntoCorrectPosition(current: ListNode, list: ListNode?): ListNode? {
        if (list == null) return list
        if (current.`val` < list.`val`) {
            current.next = list
            return current
        }

        var prev = list
        var temp = list.next
        while (temp != null && temp.`val` < current.`val`) {
            prev = temp
            temp = temp.next
        }
        prev?.let {
            val detach = prev.next
            prev.next = current
            current.next = detach
        }
        return list
    }

}