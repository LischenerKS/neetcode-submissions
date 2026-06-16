class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int curArea = calculateArea(left, right, heights);
        int maxArea = curArea;

        while (left < right) {
            if (heights[left] < heights[right]) {
                left++;
                curArea = calculateArea(left, right, heights);
                maxArea = Math.max(maxArea, curArea);
            }
            else {
                right--;
                curArea = calculateArea(left, right, heights);
                maxArea = Math.max(maxArea, curArea);
            }
        }
        return maxArea;
    }

    private int calculateArea(int left, int right, int[] heights) {
        return Math.min(heights[left], heights[right]) * (right-left);
    }
}
