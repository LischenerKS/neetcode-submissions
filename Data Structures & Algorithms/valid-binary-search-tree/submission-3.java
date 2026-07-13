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
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean isValidNode(TreeNode node, int maxVal, int minVal) {
        if (node == null) return true;

        if (maxVal <= node.val || minVal >= node.val) return false;

        boolean isLeftOk = isValidNode(node.left, Math.min(maxVal, node.val), minVal); 
        boolean isRightOk = isValidNode(node.right, maxVal, Math.max(minVal, node.val));
        return isLeftOk && isRightOk;
    }
}
