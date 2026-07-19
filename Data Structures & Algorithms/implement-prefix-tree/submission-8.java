class PrefixTree {
    private Node root;

    public PrefixTree() {
        root = new Node(false);
    }

    public void insert(String word) {
        Node i = root;
        for (char c : word.toCharArray()) {
            if (!i.nextCharToNextNode.containsKey(c)) {
                i.nextCharToNextNode.put(c, new Node(false));
            }
            i = i.nextCharToNextNode.get(c);
        }
        i.isConsistsVal = true;
    }

    public boolean search(String word) {
        Node i = root;
        for (char c : word.toCharArray()) {
            if (!i.nextCharToNextNode.containsKey(c)) {
                return false;
            }
            i = i.nextCharToNextNode.get(c);
        }
        return i.isConsistsVal;
    }

    public boolean startsWith(String prefix) {
        Node i = root;
        for (char c : prefix.toCharArray()) {
            if (!i.nextCharToNextNode.containsKey(c)) {
                return false;
            }
            i = i.nextCharToNextNode.get(c);
        }
        return true;
    }

    private class Node {
        boolean isConsistsVal;
        Map<Character, Node> nextCharToNextNode;

        public Node(boolean isConsistsVal) {
            this.nextCharToNextNode = new HashMap(); 
            this.isConsistsVal = isConsistsVal;
        }
    }
}
