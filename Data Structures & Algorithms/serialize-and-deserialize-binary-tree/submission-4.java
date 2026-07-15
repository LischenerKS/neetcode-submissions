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

public class Codec {
    int dataI = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "-1001";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (dataI >= data.length()) return null;

        StringBuilder sb = new StringBuilder();

        while (dataI < data.length() && data.charAt(dataI) != ',') {
            sb.append(data.charAt(dataI));
            dataI++;
        }
        dataI++;

        int val = Integer.parseInt(sb.toString());
        
        if (val == -1001) return null;

        TreeNode node = new TreeNode(val);
        node.left = deserialize(data);
        node.right = deserialize(data);

        return node;
        
    }
}
