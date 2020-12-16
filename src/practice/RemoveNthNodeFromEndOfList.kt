package practice

/**
 *  @author EfeDaniel
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/problem
 * Progress: Done
 */
object RemoveNthNodeFromEndOfList {

    // ListNode Class Definition
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    // Main Method. For tests
    @JvmStatic
    fun main(args: Array<String>) {
        val l1 = ListNode(1).also { one ->
            one.next = ListNode(2).also { two ->
                two.next = ListNode(3)
            }
        }

        var answer = removeNthFromEnd(l1, 3)
        while (answer != null) {
            print("${answer.`val`} -> ")
            answer = answer.next
        }
    }

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

    data class NodeIndex(
        var index: Int,
        var node: ListNode
    )

}