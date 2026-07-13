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
    public int goodNodes(TreeNode root) {
        return getGoodNodes(root, Integer.MIN_VALUE);
    }

    public int getGoodNodes(TreeNode node, int maxVal) {
        if (node == null) return 0;
        
        int ans = 0;
        
        if (node.val >= maxVal) {
            maxVal = node.val;
            ans = 1;
        }

        ans += getGoodNodes(node.left, maxVal);
        ans += getGoodNodes(node.right, maxVal);

        return ans;
    }
}
