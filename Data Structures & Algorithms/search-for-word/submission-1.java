class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] isUsed = new boolean[board.length][board[0].length];
                    if (backtrack(board, isUsed, new StringBuilder(), word, i, j)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] isUsed, StringBuilder sb, String word, int i, int j) {
        int addedCharIndex = sb.length();
        sb.append(board[i][j]);
        isUsed[i][j] = true;

        if (sb.length() == word.length() && word.equals(sb.toString())) {
            return true;
        }

        boolean up = false;
        if (i > 0 && !isUsed[i-1][j] && word.charAt(sb.length()) == board[i-1][j]) {
            up = backtrack(board, isUsed, sb, word, i-1, j);
        }
        if (up) return true;

        boolean left = false;
        if (j > 0 && !isUsed[i][j-1] && word.charAt(sb.length()) == board[i][j-1]) {
            left = backtrack(board, isUsed, sb, word, i, j-1);
        }
        if (left) return true;

        boolean right = false;
        if (j < board[0].length-1 && !isUsed[i][j+1] && word.charAt(sb.length()) == board[i][j+1]) {
            right = backtrack(board, isUsed, sb, word, i, j+1);
        }
        if (right) return true;

        boolean down = false;
        if (i < board.length-1 && !isUsed[i+1][j] && word.charAt(sb.length()) == board[i+1][j]) {
            down = backtrack(board, isUsed, sb, word, i+1, j);
        }
        if (down) return true;


        sb.deleteCharAt(addedCharIndex);
        isUsed[i][j] = false;

        return false;
    }
    
}
