package practice

/**
 *  @author EfeDaniel
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/problem
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Progress: Done
 */
object RemoveNthNodeFromEndOfList {

    /**
     * ListNode Class Declaration
     */
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Main method Used mainly for testing purposes. Tests the input case:
     * linkedList = [1, 2, 3]
     * n = 3
     *
     * output = [2, 3]
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val linkedList = ListNode(1).also { one ->
            one.next = ListNode(2).also { two ->
                two.next = ListNode(3)
            }
        }

        var answer = removeNthFromEnd(linkedList, 3)
        while (answer != null) {
            print("${answer.`val`} -> ")
            answer = answer.next
        }
    }

    /**
     * Solution Method
     * It loops over the linked list, whilst keeping two pointers. One at the current index of the loop.
     * The other n indexes behind the first index.
     * At the end of the loop, it removes the next node to the second pointer.
     *
     * The same constant variables are created, hence an O(1) space complexity.
     * The linked list is also looped over once, hence a linear time complexity.
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var h = head ?: return head
        val firstPointer = NodeIndex(0, h)
        val secondPointer = NodeIndex(0, h)

        while (true) {
            if (h.next == null) break
            with(firstPointer) { index++; node = h.next!!; }
            if (firstPointer.index - secondPointer.index > n) {
                with(secondPointer) { index++; node = node.next!!; }
            }
            h = h.next ?: break
        }

        return when {
            firstPointer.index - secondPointer.index == n-1 -> head.next
            firstPointer.index - secondPointer.index < n -> null
            else -> {
                secondPointer.node.next?.let { secondPointer.node.next = it.next }
                head
            }
        }
    }

    /**
     * NodeIndex Class Declaration.
     * To keep note of a node and its position in the linked list.
     */
    data class NodeIndex(
        var index: Int,
        var node: ListNode
    )

}