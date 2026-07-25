/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> origToCopy = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (!origToCopy.containsKey(node)) {
            origToCopy.put(node, new Node(node.val));

            Node copy = origToCopy.get(node);

            for (Node neighbor : node.neighbors) {
                copy.neighbors.add(cloneGraph(neighbor));
            }
        }

        return origToCopy.get(node);
    }
}