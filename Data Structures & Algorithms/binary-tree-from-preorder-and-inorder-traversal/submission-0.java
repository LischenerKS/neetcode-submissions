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
    private Map<Integer, Integer> nodeValToInorderId;

    int[] preorder;
    int[] inorder;

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        nodeValToInorderId = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            nodeValToInorderId.put(inorder[i], i);
        }

        this.preorder = preorder;
        this.inorder = inorder;
        
        this.preIndex = 0;

        return getNode(0, inorder.length-1);
    }

    private TreeNode getNode(int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        
        TreeNode root = new TreeNode(preorder[preIndex]);
        this.preIndex++;

        int inorderId = nodeValToInorderId.get(root.val);

        TreeNode left = null;
        if (inLeft < inRight) {
            left = getNode(inLeft, inorderId - 1);
        }

        TreeNode right = null;
        if (inRight < inorder.length) {
            right = getNode(inorderId + 1, inRight);
        }

        root.right = right;
        root.left = left;

        
        
        return root;
    }
}
