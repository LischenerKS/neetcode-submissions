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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isNodesInSubtree(root, p, q)) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left == null && right == null) return root;
            else if (left == null) return right;
            else if (right == null) return left;
            else {
                return (height(root, left) <= height(root, right)) ? left : right;
            }
            
        }
        else {
            return null;
        }
    }

    private boolean isNodeInSubtree(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root.val == node.val) return true;
        return isNodeInSubtree(root.left, node) || isNodeInSubtree(root.right, node);
    }

    private boolean isNodesInSubtree(TreeNode root, TreeNode p, TreeNode q) {
        return isNodeInSubtree(root, p) && isNodeInSubtree(root, q);
    }

    private int height(TreeNode root, TreeNode node) {
        if (root == null) return 0;

        if (node.val == root.val) return 1;
        return Math.max(height(root.left, node), height(root.right, node)) + 1;
    }
}
