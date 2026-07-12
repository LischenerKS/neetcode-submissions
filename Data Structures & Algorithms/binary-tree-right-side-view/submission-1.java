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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        addNode(ans, root, 0);
        return ans;
    }
    
    public void addNode(List<Integer> values, TreeNode node, int level) {
        if (node == null) return;
        if (values.size() <= level) {
            values.add(node.val);
        }
        addNode(values, node.right, level+1);
        addNode(values, node.left, level+1);
        
    }
}
