class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        
        int left = 0;
        int right = nums.length - 1;
        int mid;

        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.min(nums[0], nums[1]);

        while (right - 1 > left) {
            mid = left + (right - left) / 2;

            if (nums[left] < nums[mid] && nums[mid] > nums[right]) {
                left = mid;
            }
            else if (nums[left] > nums[mid] && nums[mid] < nums[right]) {
                right = mid;
            }
            else if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
                return nums[left];
            }
        }
        return nums[right];
        
    }
}
