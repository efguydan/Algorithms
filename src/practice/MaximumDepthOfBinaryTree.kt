package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Progress: Done
 */

var max = 0

fun maxDepth(node: TreeNode?): Int {
    max = 0
    dfs(node, 1)
    return max
}

fun dfs(node: TreeNode?, depth: Int) {
    node?.run {
        if (depth > max) max = depth
        dfs(left, depth + 1)
        dfs(right, depth + 1)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}