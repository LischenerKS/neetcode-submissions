class Solution {
    public int trap(int[] height) {


        // сохранить все непересекающиеся колодцы и сложить
        boolean isRunning = true;
        int realMaxArea = 0;
        while (isRunning) {
            int left = 0;
            int right = height.length - 1;
            int curArea = calcArea(left, right, height);;
            int localMaxArea = curArea;


            int maxAreaLeft = left;
            int maxAreaRight = right;
            int maxAreaMinBorder = Math.min(height[maxAreaRight], height[maxAreaLeft]);

            if (height.length == 1) return 0;

            while (left < right) {
                
                if (height[left] < height[right]) {
                    left++;
                }
                else if (height[left] > height[right]) {
                    right--;
                }
                else {
                    if (height[left+1] > height[right-1]) left++;
                    else right--;
                }

                curArea = calcArea(left, right, height);
                if (curArea > localMaxArea) {
                    localMaxArea = curArea;
                    maxAreaLeft = left;
                    maxAreaRight = right;
                    maxAreaMinBorder = Math.min(height[maxAreaRight], height[maxAreaLeft]);
                }
            } 
            
            for (int i = maxAreaLeft+1; i < maxAreaRight; i++) {
                height[i] = Math.max(maxAreaMinBorder, height[i]);
            }
            realMaxArea += localMaxArea;
            if (localMaxArea == 0) {
                isRunning = false;
            }
        }
        
        return realMaxArea;

    }

    public int calcArea(int left, int right, int[] height) {
        int minBorder = Math.min(height[right], height[left]);
        int area = (right - left - 1) * minBorder;
        for (int i = left+1; i < right; i++) {
            area -= Math.min(minBorder, height[i]);
        }
        return area;        
    }
}
