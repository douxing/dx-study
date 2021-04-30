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
    TreeNode listify(TreeNode root) {
        TreeNode max = root;
        if (root.right != null) {
            root.right = listify(root.right);
            // assert root.right.left != null;
            max = root.right.left;
            root.right.left = null; // necessary?
        }
        TreeNode min = root;
        if (root.left != null) {
            min = listify(root.left);
            min.left.right = root;
            root.left = null;
        }
        min.left = max;
        return min;
    }
    public TreeNode increasingBST(TreeNode root) {
        // assert root != null;
        root = listify(root);
        root.left = null;
        return root;
    }
}
