class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        if (nums.length == 2) {
            if (nums[0] == target) return 0;
            else {
                return nums[1] == target ? 1 : -1;
            }
        }
        int left = 0;
        int right = nums.length;

        int cur;
        int center = left + (right - left) / 2;
        while (left < right) {
            cur = nums[center];
            if (cur < target) {
                left = center + 1;
            
            }
            else if (cur > target) {
                right = center - 1;
            }
            else {
                return center;
            }
            center = left + (right - left) / 2;



            
        }


        if (left < 0 || left == nums.length) return -1;
        return nums[left] == target ? left :-1;
    }
}
