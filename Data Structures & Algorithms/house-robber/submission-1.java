class Solution {
    public int rob(int[] nums) {
        int[] maxSum = new int[nums.length];

        maxSum[0] = nums[0];
        
        if (nums.length >= 2) {
            maxSum[1] = Math.max(maxSum[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            maxSum[i] = Math.max(maxSum[i-2] + nums[i], maxSum[i-1]);
        }

        return maxSum[maxSum.length - 1];
    }
}
