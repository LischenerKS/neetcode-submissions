class Solution {
    public int search(int[] nums, int target) {
        int gapIndex = Integer.MAX_VALUE;

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (right - 1 > left) {
            mid = left + (right - left) / 2;
            
            if (nums[left] < nums[mid] && nums[mid] > nums[right]) {
                left = mid;
            } 
            else if (nums[left] > nums[mid] && nums[mid] < nums[right]) {
                right = mid;
            }
            else if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
                gapIndex = left;
                break;
            }
        }     

        if (gapIndex == Integer.MAX_VALUE) gapIndex = right;

        int leftAns = binaryS(nums, target, 0, gapIndex);
        int rightAns = binaryS(nums, target, gapIndex, nums.length);
        
        return Math.max(leftAns, rightAns);
    }

    public int binaryS(int[] nums, int target, int left, int right) {
        if (right - left == 1) { //1 element
            return target == nums[left] ? left : -1;
        }
        else if (right - left == 2) { //2 elements
            if (target == nums[left]) return left;
            else if (target == nums[right-1]) return right-1;
            else return -1;
        }

        int mid;
        while (right - 1 > left) {
            mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid;
            }
            else if (nums[mid] < target) {
                left = mid;
            }
            else {
                return mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    
}
