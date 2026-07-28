class Solution {
    public void solve(char[][] board) {
        boolean[][] isProtected = new boolean[board.length][board[0].length];
        Deque<int[]> cellsDeq = new ArrayDeque<>();

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                isProtected[i][0] = true;
                cellsDeq.add(new int[]{i, 0});
            }
            if (board[i][board[0].length - 1] == 'O') {
                isProtected[i][board[0].length - 1] = true;
                cellsDeq.add(new int[]{i, board[0].length - 1});
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                isProtected[0][i] = true;
                cellsDeq.add(new int[]{0, i});
            }
            if (board[board.length - 1][i] == 'O') {
                isProtected[board.length - 1][i] = true;
                cellsDeq.add(new int[]{board.length - 1, i});
            }
        }


        while (!cellsDeq.isEmpty()) {
            int deqSize = cellsDeq.size();


            for (int i = 0; i < deqSize; i++) {
                int[] cellsCords = cellsDeq.poll();
                int x = cellsCords[0];
                int y = cellsCords[1];

                addCell(x-1, y, board, cellsDeq, isProtected);
                addCell(x+1, y, board, cellsDeq, isProtected);
                addCell(x, y-1, board, cellsDeq, isProtected);
                addCell(x, y+1, board, cellsDeq, isProtected);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !isProtected[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }      
    }

    private void addCell(int i, int j, char[][] board, Deque<int[]> cellsDeq, boolean[][] isProtected) {
        if (i < 0 || i >= board.length) return;
        if (j < 0 || j >= board[0].length) return;
        if (board[i][j] != 'O') return;
        if (isProtected[i][j]) return;

        isProtected[i][j] = true;
        cellsDeq.add(new int[]{i, j});
    }
}
