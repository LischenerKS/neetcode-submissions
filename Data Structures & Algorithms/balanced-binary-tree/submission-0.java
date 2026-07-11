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
    private boolean isOk = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isOk;
    }

    public int maxDepth(TreeNode node) {
        if (!isOk) return 0;

        if (node == null) return 0;

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        if (Math.abs(rightDepth - leftDepth) > 1) {
            isOk = false;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
