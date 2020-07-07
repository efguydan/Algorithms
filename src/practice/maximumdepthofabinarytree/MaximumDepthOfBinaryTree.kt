package practice.maximumdepthofabinarytree

var max = 0;

fun maxDepth(node: TreeNode?, depth: Int = 1): Int {
    node?.run {
        if (depth > max ) max = depth
        maxDepth(left, depth + 1)
        maxDepth(right, depth + 1)
    }
    return max
}