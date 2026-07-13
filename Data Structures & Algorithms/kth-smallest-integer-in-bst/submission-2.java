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
    private boolean isMinFinded = false;
    private int cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        Integer left = null;
        if (!isMinFinded && root == null) {
            isMinFinded = true;
            return -1;
        }
        else if (!isMinFinded) {
            left = kthSmallest(root.left, k);
        }

        if (isMinFinded) {
            if (root == null) return -1;
            cnt++;

            if (cnt == k) return root.val;
            
            if (left == null) {
                left = kthSmallest(root.left, k);
            } 

            return Math.max(left, kthSmallest(root.right, k));
        }
        return -1;



    }


}
