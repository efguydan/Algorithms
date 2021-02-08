package practice.interviewcake.treesandgraphs;

public class BinarySearchTreeChecker {

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

    public static void main(String[] args) {
        //TRUE
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final boolean result = isBinarySearchTree(root);
        System.out.println(result);

        //TRUE
        final BinaryTreeNode root2 = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final BinaryTreeNode b = root.insertRight(70);
        b.insertLeft(60);
        b.insertRight(80);
        final boolean result2 = isBinarySearchTree(root2);
        System.out.println(result2);
    }

    public static int currentValue = Integer.MIN_VALUE;

    public static boolean isBinarySearchTree(BinaryTreeNode root) {
        return dfs(root);
    }

    public static boolean dfs(BinaryTreeNode node) {
        if (node.left != null && !dfs(node.left)) return false;
        if (node.value < currentValue) return false; else currentValue = node.value;
        if (node.right != null && !dfs(node.right)) return false;
        return true;
    }

}
