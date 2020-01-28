package practice.ValidateBinarySearchTree;

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/validate-binary-search-tree
 * Progress: Done
 */

public class ValidateBinarySearchTree {

    private int currentValue = 0;
    private boolean firstTime = true;

    public boolean isValidBST(TreeNode root) {
        currentValue = 0;
        if (root == null) return true; else return traverse(root, true);
    }

    private boolean traverse(TreeNode node, boolean status) {
        if (node.left != null)
            status = status && traverse(node.left, status);
        status = status && (firstTime || node.val > currentValue);
        firstTime = false;
        currentValue = node.val;
        if (node.right != null)
            status = status && traverse(node.right, status);
        return status;
    }

}
