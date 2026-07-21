class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Node iterNode = root;
            for (Character c : word.toCharArray()) {
                if (!iterNode.charToNextNode.containsKey(c)) {
                    iterNode.charToNextNode.put(c, new Node());
                }

                iterNode = iterNode.charToNextNode.get(c);
            }
            iterNode.wordIndex = i;
        }

        List<String> ans = new ArrayList<>();
        boolean[][] isUsed = new boolean[board.length][board[0].length]; 

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, root, i, j, ans, words, isUsed);
            }
        }

        return ans;
    }

    private void search(char[][] board, Node node, int i, int j, List<String> ans, String[] words, boolean[][] isUsed) {
        if (i < 0 || i >= board.length) return;
        if (j < 0 || j >= board[0].length) return;
        if (isUsed[i][j]) return;


        Character c = board[i][j];

        if (!node.charToNextNode.containsKey(c)) {
            return;
        }

        node = node.charToNextNode.get(c);
        isUsed[i][j] = true;

        if (node.wordIndex != -1) {
            ans.add(words[node.wordIndex]);
            node.wordIndex = -1;
        }

        search(board, node, i+1, j, ans, words, isUsed);
        search(board, node, i-1, j, ans, words, isUsed);
        search(board, node, i, j-1, ans, words, isUsed);
        search(board, node, i, j+1, ans, words, isUsed);

        
        isUsed[i][j] = false;
        
        
    }
}




class Node {
    Map<Character, Node> charToNextNode = new HashMap<>();
    int wordIndex = -1;
    
}