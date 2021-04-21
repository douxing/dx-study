package leetcode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BSTIterator {
    List<Integer> l = new LinkedList();

    void visit(TreeNode root) {
        if (root == null) {
            return;
        }

        visit(root.left);
        this.l.add(root.val);
        visit(root.right);
    }

    public BSTIterator(TreeNode root) {
        visit(root);
    }
    
    public int next() {
        return l.remove(0);
    }
    
    public boolean hasNext() {
        return !l.isEmpty();
    }
}
