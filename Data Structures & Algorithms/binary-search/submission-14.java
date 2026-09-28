class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (right - left > 1) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] <= target) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return target == nums[left] ? left : -1;
    }
}
