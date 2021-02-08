package practice.interviewcake.treesandgraphs;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/second-largest-item-in-bst?course=fc1&section=trees-graphs
 * Progress: Done
 */
public class SecondLargestItemInABinarySearchTree {

    public class BinaryTreeNode {

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

    public static int findSecondLargest(BinaryTreeNode rootNode) {
        if (rootNode == null || (rootNode.left == null
                && rootNode.right == null)) {
            throw new IllegalArgumentException("Tree must have at least 2 nodes");
        }

        BinaryTreeNode current = rootNode;

        while (true) {
            if (current.left != null && current.right == null) {
                return findLargest(current.left);
            }

            if (current.right != null &&
                    current.right.left == null &&
                    current.right.right == null) {
                return current.value;
            }

            current = current.right;
        }
    }

    private static int findLargest(BinaryTreeNode rootNode) {
        BinaryTreeNode current = rootNode;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

}
