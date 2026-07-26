class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];

        //pacific
        Deque<int[]> cellsDeq = new ArrayDeque<>();
        for (int i = 0; i < heights[0].length; i++) {
            cellsDeq.add(new int[]{0, i});
            pacific[0][i] = true;
        }    
        for (int i = 0; i < heights.length; i++) {
            cellsDeq.add(new int[]{i, 0});
            pacific[i][0] = true;
        } 

        int deqSize;
        int[] cords;
        int i,j;
        int calledHeight;
        while (!cellsDeq.isEmpty()) {
            deqSize = cellsDeq.size();

            for (int t = 0; t < deqSize; t++) {
                cords = cellsDeq.poll();
                i = cords[0];
                j = cords[1];
                calledHeight = heights[i][j];


                addCell(i-1, j, heights, cellsDeq, calledHeight, pacific);
                addCell(i+1, j, heights, cellsDeq, calledHeight, pacific);
                addCell(i,j- 1, heights, cellsDeq, calledHeight, pacific);
                addCell(i,j+ 1, heights, cellsDeq, calledHeight, pacific);
            }
        }



        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        //atlantic
        cellsDeq = new ArrayDeque<>();

        for (i = 0; i < heights[0].length; i++) {
            cellsDeq.add(new int[]{heights.length - 1, i});
            atlantic[heights.length - 1][i] = true;
        }    
        for (i = 0; i < heights.length; i++) {
            cellsDeq.add(new int[]{i, heights[0].length - 1});
            atlantic[i][heights[0].length - 1] = true;
        } 


        while (!cellsDeq.isEmpty()) {
            deqSize = cellsDeq.size();

            for (int t = 0; t < deqSize; t++) {
                cords = cellsDeq.poll();
                i = cords[0];
                j = cords[1];
                calledHeight = heights[i][j];


                addCell(i-1, j, heights, cellsDeq, calledHeight, atlantic);
                addCell(i+1, j, heights, cellsDeq, calledHeight, atlantic);
                addCell(i,j- 1, heights, cellsDeq, calledHeight, atlantic);
                addCell(i,j+ 1, heights, cellsDeq, calledHeight, atlantic);
            }
        }


        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cordsAns;
        for (i = 0; i < heights.length; i++) {
            for (j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    cordsAns = new ArrayList<>();
                    cordsAns.add(i);
                    cordsAns.add(j);
                    ans.add(cordsAns);
                }
            }
        }
        return ans;
    }

    private void addCell(int i, int j, int[][] heights, Deque<int[]> cellsDeq, int calledHeight, boolean[][] ocean) {
        if (i < 0 || i >= heights.length) return;
        if (j < 0 || j >= heights[0].length) return;
        if (calledHeight > heights[i][j]) return;
        if (ocean[i][j]) return;

        ocean[i][j] = true;
        cellsDeq.add(new int[]{i, j});
    }


    
}
