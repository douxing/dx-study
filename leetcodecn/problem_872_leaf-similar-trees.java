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
    void dfs(TreeNode n, List<Integer> l) {
        if (n.left == null && n.right == null) {
            l.add(n.val);
            return;
        } 
        
        if (n.left != null) {
            dfs(n.left, l);
        }
        if (n.right != null) {
            dfs(n.right, l);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1= new ArrayList();
        dfs(root1, l1);

        List<Integer> l2= new ArrayList();
        dfs(root2, l2);

        return l1.equals(l2);
    }
}
