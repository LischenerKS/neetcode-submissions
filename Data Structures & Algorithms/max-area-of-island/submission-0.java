class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int curArea;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    curArea = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int cnt = 1;

        if (i > 0 && grid[i-1][j] == 1) {
            cnt += dfs(grid, i-1, j);
        }


        if (i < grid.length - 1 && grid[i+1][j] == 1) {
            cnt += dfs(grid, i+1, j);
        }


        if (j > 0 && grid[i][j-1] == 1) {
            cnt += dfs(grid, i, j-1);
        }


        if (j < grid[0].length - 1 && grid[i][j+1] == 1) {
            cnt += dfs(grid, i, j+1);
        }

        return cnt;
    }
}
