/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {

    public Node lowestCommonAncestor(Node p, Node q) {
        int pLevel = getLevel(p);
        int qLevel = getLevel(q);
        return lca(p, pLevel, q, qLevel);
    }

    private Node lca(Node p, int pLevel, Node q, int qLevel) {
        if (p.parent == q.parent) {
            return p.parent;
        }
        else if (p.parent == q) {
            return q;
        }
        else if (q.parent == p) {
            return p;
        }

        if (pLevel == qLevel) {
            return lca(p.parent, pLevel - 1, q.parent, qLevel - 1);
        }   
        else if (pLevel < qLevel) {
            return lca(p, pLevel, q.parent, qLevel - 1);
        }
        return lca(p.parent, pLevel - 1, q, qLevel);
    }

    private int getLevel(Node node) {
        int level = 1;
        while (node.parent != null) {
            node = node.parent;
            level++;
        }

        return level;
    }

}