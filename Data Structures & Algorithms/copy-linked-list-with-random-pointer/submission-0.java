/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopyNode = new HashMap<>();
        return copyThisNode(head, oldToCopyNode);
    }
    
    public Node copyThisNode(Node node, Map<Node, Node> oldToCopyNode) {
        if (node == null) return null;
        else if (oldToCopyNode.containsKey(node)) {
            return oldToCopyNode.get(node);
        }
        else {
            Node deepCopy = new Node(node.val);
            oldToCopyNode.put(node, deepCopy);
            
            deepCopy.next = copyThisNode(node.next, oldToCopyNode);
            deepCopy.random = copyThisNode(node.random, oldToCopyNode);

            
            return deepCopy;
        }
        
    }

}
