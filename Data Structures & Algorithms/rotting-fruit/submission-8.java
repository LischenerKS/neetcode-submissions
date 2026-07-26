class Solution {
    private int remainFresh;
    public int orangesRotting(int[][] grid) {
        Deque<Cord> cellDeq = new ArrayDeque<>();
        this.remainFresh = 0;

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

        int stepCnt = -1;
        while (!cellDeq.isEmpty()) {
            int deqSize = cellDeq.size();

            Cord cord;
            int i,j;
            for (int t = 0; t < deqSize; t++) {
                cord = cellDeq.poll();
                i = cord.i();
                j = cord.j();


                addCell(i-1, j, cellDeq, grid);
                addCell(i+1, j, cellDeq, grid);
                addCell(i, j-1, cellDeq, grid);
                addCell(i, j+1, cellDeq, grid);
            }
            stepCnt++;
        }

        return (remainFresh == 0) ? Math.max(stepCnt, 0) : -1;
    }

    private void addCell(int i, int j, Deque<Cord> cellDeq, int[][] grid) {
        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[0].length) return;
        if (grid[i][j] != 1) return;

        grid[i][j] = 2;
        this.remainFresh--;

        cellDeq.add(new Cord(i, j));
    }

    private record Cord(int i, int j) {}
}
