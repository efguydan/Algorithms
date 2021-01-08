package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/reverse-linked-list-ii/
 * Progress: Done
 */
object ReverseLinkedListII {

    /**
     * ListNode Class Definition
     */
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val head = ListNode(1).also { one ->
            one.next = ListNode(2).also { two ->
                two.next = ListNode(3).also { three ->
                    three.next = ListNode(4).also { four ->
                        four.next = ListNode(5)
                    }
                }
            }
        }

        var answer = reverseBetween(head, 2, 4)
        while (answer != null) {
            print("${answer.`val`} -> ")
            answer = answer.next
        }
    }

    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        var current = head
        var detach = head

        for (i in 1 until m) {
            detach = current
            current = current?.next
        }
        val temp = current

        var prev: ListNode? = null
        var next: ListNode?

        for (i in m..n) {
            next = current?.next
            current?.next = prev
            prev = current
            current = next
        }
        temp?.next = current

        return if (m == 1) prev else {
            detach?.next = prev
            head
        }
    }

}