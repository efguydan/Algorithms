package practice;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class kthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Set elements = new TreeSet<Integer>();
        addElements(elements, root);
        return new ArrayList<Integer>(elements).get(k-1);
    }

    private void addElements(Set elements, TreeNode node) {
        if (node == null) return;
        elements.add(node.val);
        addElements(elements, node.left);
        addElements(elements, node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
