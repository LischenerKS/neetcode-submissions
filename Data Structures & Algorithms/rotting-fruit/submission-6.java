class Solution {
    public int orangesRotting(int[][] grid) {
        int rottenCnt = 0;
        Deque<Cord> cellDeq = new ArrayDeque<>();
        int remainFresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    cellDeq.add(new Cord(i, j));
                }
                else if (grid[i][j] == 1) {
                    remainFresh++;
                }
            }
        }

        int stepCnt = 0;
        while (!cellDeq.isEmpty()) {
            int deqSize = cellDeq.size();

            Cord cord;
            int i,j;
            boolean isFreshMeeted = false;
            for (int t = 0; t < deqSize; t++) {
                cord = cellDeq.poll();
                i = cord.i();
                j = cord.j();

                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    remainFresh--;
                    isFreshMeeted = true;
                }
                addCell(i-1, j, cellDeq, grid);
                addCell(i+1, j, cellDeq, grid);
                addCell(i, j-1, cellDeq, grid);
                addCell(i, j+1, cellDeq, grid);
            }
            if (isFreshMeeted) stepCnt++;
        }

        return (remainFresh == 0) ? Math.max(stepCnt, 0) : -1;
    }

    private void addCell(int i, int j, Deque<Cord> cellDeq, int[][] grid) {
        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[0].length) return;
        if (grid[i][j] != 1) return;

        cellDeq.add(new Cord(i, j));
    }

    private record Cord(int i, int j) {}
}
