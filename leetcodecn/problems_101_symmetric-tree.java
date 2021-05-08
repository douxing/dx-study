/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean rec(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            return left.val == right.val 
            && rec(left.left, right.right) 
            && rec(left.right, right.left);
        } else {
            return false;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        return rec(root.left, root.right);
    }
}
