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
    public Integer diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxDepthLeft = maxDepth(node.left);
        int maxDepthRight = maxDepth(node.right);

        diameter = Math.max(diameter, maxDepthLeft + maxDepthRight);
        return Math.max(maxDepthLeft, maxDepthRight) + 1;
    }
}
