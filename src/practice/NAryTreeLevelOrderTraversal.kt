package practice

import java.util.*

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * Progress: Done
 */
class NAryTreeLevelOrderTraversal { companion object {

    @JvmStatic
    fun main(args: Array<String>) {
        var root = Node(1)
        var child = Node(3)
        child.children = listOf(Node(5), Node(6))
        root.children = listOf(child, Node(2), Node(4))

        println(levelOrder(root))
    }

    var answer = mutableListOf(mutableListOf<Int>())

    fun levelOrder(root: Node?): List<List<Int>> {
        answer.clear()
        bfs(root)
        return answer
    }

    private fun bfs(root: Node?) {
        val queue: Queue<Node?> = LinkedList()
        root?.let { queue.run {
            add(it)
            add(null)
        } }

        var tempList = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val node = queue.remove()

            if (node == null) {
                if (tempList.isNotEmpty()) answer.add(tempList)
                if (queue.isEmpty()) break;
                tempList = mutableListOf()
                queue.add(null)
            } else {
                for (child in node.children) {
                    child?.let { queue.add(it) }
                }
            }
            node?.`val`?.let { tempList.add(it) }
        }
    }

} }

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}