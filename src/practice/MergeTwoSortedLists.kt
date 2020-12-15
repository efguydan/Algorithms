package practice

/**
 *  @author EfeDaniel
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/problem
 * Progress: Done
 */
object MergeTwoSortedLists {

    // ListNode Class
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    // Main class, for tests
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

    // Solution
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

    private fun ListNode.insertImmediate(other: ListNode) {
        next = other.also { other.next = next }
    }

}