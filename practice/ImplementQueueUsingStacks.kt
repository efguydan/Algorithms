package practice

import java.util.*

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/implement-queue-using-stacks/
 * Progress: Done
 */
class MyQueue() {

    /** Initialize your data structure here. */
    private val stack = Stack<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) = stack.push(x)

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int = traverseThrough(true)

    /** Get the front element. */
    fun peek() = traverseThrough(false)

    private fun traverseThrough(removeFirst: Boolean): Int {
        val tempStack = Stack<Int>()
        while (stack.size > 1) tempStack.push(stack.pop())
        val toReturn = if (removeFirst) stack.pop() else tempStack.push(stack.pop())
        while (tempStack.isNotEmpty()) stack.push(tempStack.pop())
        return toReturn
    }

    /** Returns whether the queue is empty. */
    fun empty() = stack.isEmpty()

}