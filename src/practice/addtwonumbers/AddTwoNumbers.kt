package practice.addtwonumbers

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/add-two-numbers/
 * Progress: Done
 */

private var head: ListNode? = null
private var current: ListNode? = null

fun addTwoNumbers(l1: ListNode?, l2: ListNode?, overflow: Int = 0): ListNode? {
    if (l1 == null && l2 == null) {
        if (overflow > 0) addNode(overflow)
        return head
    }
    val temp = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + overflow
    addNode(if (temp > 9) temp - 10 else temp)
    addTwoNumbers(l1?.next, l2?.next, if (temp > 9) 1 else 0)
    return head
}

fun addNode(value: Int) {
    if (head == null) {
        head = ListNode(value)
        current = head
    } else {
        current?.next = ListNode(value)
        current = current?.next
    }
}