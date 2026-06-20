class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n;

        int absoluteCenter;
        int centerFirst;
        int centerSecond;
        int i;
        while (left < right) {
            absoluteCenter = (left + (right-left) / 2);
            centerFirst = absoluteCenter / n; 
            centerSecond = absoluteCenter % n;
            i = matrix[centerFirst][centerSecond];
            if (i == target) {
                return true;
            } 
            else if (i > target) {
                right = absoluteCenter - 1;
            }
            else if (i < target) {
                left = absoluteCenter + 1;
            }
        }
        
        absoluteCenter = (left + (right-left) / 2);
        centerFirst = absoluteCenter / n; 
        centerSecond = absoluteCenter % n;
        try {
            i = matrix[centerFirst][centerSecond];
            return  i == target;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        
            

    }
}
