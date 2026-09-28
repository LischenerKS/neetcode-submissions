class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (right - left > 1) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] < target) {
                left = mid;
            }
            else if (nums[mid] > target) {
                right = mid;
            }
            else {
                return mid;
            }
        }
        return target == nums[left] ? left : -1;
    }
}
