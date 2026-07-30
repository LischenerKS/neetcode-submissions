class Solution {
    public int rob(int[] nums) {
        int[] maxSumWithFirst = new int[nums.length];
        int[] maxSumWithoutFirst = new int[nums.length];

        maxSumWithFirst[0] = nums[0];

        if (nums.length >= 2) {
            maxSumWithFirst[1] = Math.max(nums[1], maxSumWithFirst[0]);
            maxSumWithoutFirst[1] = nums[1];
        }

        for (int i = 2; i < nums.length; i++) {
            if (i == nums.length - 1) {
                maxSumWithFirst[i] = Math.max(maxSumWithFirst[i-1], maxSumWithFirst[i-2]);
            }
            else {
                maxSumWithFirst[i] = Math.max(maxSumWithFirst[i-1], maxSumWithFirst[i-2] + nums[i]);
            }
            maxSumWithoutFirst[i] = Math.max(maxSumWithoutFirst[i-1], maxSumWithoutFirst[i-2] + nums[i]);
        }

        return Math.max(maxSumWithFirst[nums.length - 1], maxSumWithoutFirst[nums.length -1 ]);

    }
}
