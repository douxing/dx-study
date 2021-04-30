class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int res = root.val <= high && root.val >= low ? root.val : 0;
        return res + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
