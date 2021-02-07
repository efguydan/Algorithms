package practice.interviewcake.treesandgraphs;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/balanced-binary-tree?course=fc1&section=trees-graphs
 * Progress: Done
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.insertLeft(4).insertLeft(1);
        root.insertRight(2).insertRight(9);
        final boolean result = isBalanced(root);
        System.out.println(result);
    }

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static int min = Integer.MAX_VALUE;
    public static int max = 0;

    public static boolean isBalanced(BinaryTreeNode treeRoot) {
        min = Integer.MAX_VALUE;
        max = 0;
        dfs(treeRoot, 0);
        return max - min < 2;
    }

    private static void dfs(BinaryTreeNode node, int depth) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            min = Math.min(min, depth);
            max = Math.max(max, depth);
        }
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }

}
