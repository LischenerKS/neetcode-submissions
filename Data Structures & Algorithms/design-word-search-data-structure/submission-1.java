class Node {
    Node[] next = new Node[26];
    boolean isEndOfWord = false;
}

class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node i = root;
        for (char c : word.toCharArray()) {
            if (i.next[c - 'a'] == null) {
                i.next[c - 'a'] = new Node();
            }
            
            i = i.next[c - 'a'];
        }
        i.isEndOfWord = true;
    }

    public boolean search(String word) {
        return recSearch(word, 0, root);        
    }

    private boolean recSearch(String word, int i, Node node) {
        char c =  word.charAt(i);

        if (c != '.') {
            if (node.next[c - 'a'] == null) {
                return false;
            }

            if (i == word.length() - 1) {
                return node.next[c - 'a'].isEndOfWord;
            }
            return recSearch(word, i+1, node.next[c - 'a']);
        }
        else {
            if (i == word.length() - 1) {
                for (int j = 0; j < 26; j++) {
                    if (node.next[j] != null && node.next[j].isEndOfWord) {
                        return true;   
                    }
                }   
                return false;
            }

            boolean isOk = false;
            for (int j = 0; j < 26; j++) {
                if (node.next[j] != null && recSearch(word, i+1, node.next[j])) {
                    return true;
                }
                
            }

            return false;
        }
    }
}
