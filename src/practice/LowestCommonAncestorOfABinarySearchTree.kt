package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Progress: Done
 */
object LowestCommonAncestorOfABinarySearchTree {

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        var currentNode = root ?: return root
        var a = p ?: return root
        var b = q ?: return root

        while (true) {
            currentNode = if (a.`val` < currentNode.`val` && b.`val` < currentNode.`val`) {
                currentNode.left ?: return root
            } else if (a.`val` > currentNode.`val` && b.`val` > currentNode.`val`) {
                currentNode.right ?: return root
            } else {
                return currentNode
            }
        }

    }

}