class Solution {
    public int numIslands(char[][] grid) {
        int cntLands = 0;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cntLands++;
                    addLand(grid, i, j);
                }
            }
        }
        return cntLands;
    }

    private void addLand(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[0].length) return;
        if (grid[i][j] != '1') return;

        grid[i][j] = '0';
        addLand(grid, i-1, j);
        addLand(grid, i+1, j);
        addLand(grid, i, j-1);
        addLand(grid, i, j+1);
    }
}
