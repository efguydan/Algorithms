package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Progress: Done
 */
class MinimumDepthOfBinaryTree {
    companion object {

        var min = Int.MAX_VALUE

        fun minDepth(root: TreeNode?): Int {
            min = 0
            root?.let {
                min = Int.MAX_VALUE
                dfs(it, 1)
            }
            return min
        }

        private fun dfs(node: TreeNode?, depth: Int) {
            node?.run {
                dfs(left, depth+1)
                dfs(right, depth+1)
                if (isLeaf() && depth < min) min = depth
            }
        }

        private fun TreeNode.isLeaf() = left == null && right == null

    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}