class Solution {
    private final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        final int ROW_LENGTH = grid[0].length;
        final int COL_LENGTH = grid.length;

        Deque<int[]> cellDeq = new ArrayDeque<>();
        
        for (int i = 0; i < COL_LENGTH; i++) {
            for (int j = 0; j < ROW_LENGTH; j++) {
                if (grid[i][j] == 0) {
                    cellDeq.add(new int[]{i, j});
                }
            }
        }

        int dist = 0;
        while (!cellDeq.isEmpty()) {
            int[] cellCords;
            int x,y;
            int size = cellDeq.size();
            for (int i = 0; i < size; i++) {
                cellCords = cellDeq.poll();
                x = cellCords[0];
                y = cellCords[1];

                if (grid[x][y] == INF || grid[x][y] == 0) {
                    grid[x][y] = dist;
                    addCell(grid, x-1, y, cellDeq);
                    addCell(grid, x+1, y, cellDeq);
                    addCell(grid, x, y-1, cellDeq);
                    addCell(grid, x, y+1, cellDeq);
                }
            }
            dist++;
        }

    }

    private void addCell(int[][] grid, int i, int j, Deque<int[]> cellDeq) {
        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[0].length) return;
        if (grid[i][j] != INF) return;

        cellDeq.add(new int[]{i, j});
    }

    


    
}
