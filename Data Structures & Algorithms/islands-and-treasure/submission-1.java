class Solution {
    private final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, int i, int j, int cnt) {
        if (grid[i][j] < cnt) return;

        grid[i][j] = cnt;

        if (i > 0 && grid[i-1][j] != -1) {
            dfs(grid, i-1, j, cnt+1);
        }

        if (j > 0 && grid[i][j-1] != -1) {
            dfs(grid, i, j-1, cnt+1);
        }

        if (i < grid.length-1 && grid[i+1][j] != -1) {
            dfs(grid, i+1, j, cnt+1);
        }

        if (j < grid[0].length-1 && grid[i][j+1] != -1) {
            dfs(grid, i, j+1, cnt+1);
        }
    }

    
}
