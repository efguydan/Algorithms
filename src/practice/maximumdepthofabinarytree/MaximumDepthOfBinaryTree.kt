package practice.maximumdepthofabinarytree

var max = 0

fun maxDepth(node: TreeNode?): Int {
    max = 0
    dfs(node, 1)
    return max
}

fun dfs(node: TreeNode?, depth: Int) {
    node?.run {
        if (depth > max ) max = depth
        dfs(left, depth + 1)
        dfs(right, depth + 1)
    }
}