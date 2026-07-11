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
    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        depthFromRoot(root, 0);
        return maxDepth;
    }

    public void depthFromRoot(TreeNode node, int curDepth) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            maxDepth = Math.max(maxDepth, curDepth+1);
        }
        else {
            depthFromRoot(node.left, curDepth+1);
            depthFromRoot(node.right, curDepth+1);
        }
    
    }
}
