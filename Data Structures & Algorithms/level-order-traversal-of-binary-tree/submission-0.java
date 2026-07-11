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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        addNode(ans, root, 0);
        return ans;
    }

    public void addNode(List<List<Integer>> nodes, TreeNode node, int level) {
        if (node == null) return;
        if (nodes.size() <= level) nodes.add(new ArrayList<>());

        nodes.get(level).add(node.val);
        addNode(nodes, node.left, level+1);
        addNode(nodes, node.right, level+1);
    }
}
