package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Progress: Done
 */

class RemoveDuplicatesFromSortedList {

    companion object {
        fun deleteDuplicates(head: ListNode?): ListNode? {
            var currentNode = head
            while (currentNode != null) {
                while (currentNode.next != null && currentNode.next!!.`val` == currentNode.`val`) {
                    currentNode.next = currentNode!!.next!!.next
                }
                currentNode = currentNode.next
            }
            return head
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

}