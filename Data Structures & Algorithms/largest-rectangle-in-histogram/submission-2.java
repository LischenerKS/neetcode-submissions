class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nearestLowerLeftBarIndex = new int[heights.length];
        int[] nearestLowerRightBarIndex = new int[heights.length];


        if (heights.length == 1) return heights[0];

        for (int i = 0; i < heights.length; i++) {
            nearestLowerLeftBarIndex[i] = calcNearestLowerLeftBarIndexForHeight(
                heights,
                nearestLowerLeftBarIndex,
                i,
                heights[i]
            );
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            nearestLowerRightBarIndex[i] = calcNearestLowerRightBarIndexForHeight(
                heights,
                nearestLowerRightBarIndex,
                i,
                heights[i]
            );
        }

        int curHeight;
        int maxS = 0;
        int width;
        for (int i = 0; i < heights.length; i++) {
            curHeight = heights[i];
            width = nearestLowerRightBarIndex[i] - nearestLowerLeftBarIndex[i] - 1;

            maxS = Math.max(maxS, curHeight*width);
        }
        return maxS;

    }


    private int calcNearestLowerLeftBarIndexForHeight(int[] heights, int[] nearestLowerLeftBarIndex, int i, int height) {
        if (i == 0) return -1;
        int left = heights[i-1];
        if (left == height) {
            return nearestLowerLeftBarIndex[i-1];
        }
        else if (left < height) {
            return i-1;
        }
        else {
            return calcNearestLowerLeftBarIndexForHeight(heights, nearestLowerLeftBarIndex, i-1, height);
        }
    }

    private int calcNearestLowerRightBarIndexForHeight(int[] heights, int[] nearestLowerRightBarIndex, int i, int height) {
        if (i == heights.length - 1) return heights.length;
        int right = heights[i+1];
        if (right == height) {
            return nearestLowerRightBarIndex[i+1];
        }
        else if (right < height) {
            return i+1;
        }
        else {
            return calcNearestLowerRightBarIndexForHeight(heights, nearestLowerRightBarIndex, i+1, height);
        }
    }
}
