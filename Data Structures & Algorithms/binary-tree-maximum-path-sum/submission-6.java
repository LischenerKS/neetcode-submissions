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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        this.maxSum = Integer.MIN_VALUE;  
        dfs(root);  
        return maxSum;
    }
    
    // вернуть максимальную сумму под этой нодой
    private int dfs(TreeNode node) {
        if (node == null) return -1001;

        

        int onlyLeft = dfs(node.left);
        int onlyRight = dfs(node.right);

        int onlyThisNode = node.val;
        int leftThis = onlyLeft + onlyThisNode;
        int thisRight = onlyThisNode + onlyRight;

        
        
        int ans = onlyThisNode;
        ans = Math.max(ans, leftThis);
        ans = Math.max(ans, thisRight);

        int lefThisRight = onlyLeft + onlyThisNode + onlyRight;

        this.maxSum = Math.max(maxSum, ans);
        this.maxSum = Math.max(maxSum, lefThisRight);
        
        return ans;
    }
}
