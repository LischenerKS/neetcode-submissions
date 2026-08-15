class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int min = 1;
        int max = 1;


        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i] * max;
            max = max(nums[i] * max, nums[i] * min, nums[i]);
            min = min(temp, nums[i] * min, nums[i]);

            ans = Math.max(ans, max);
        }

        return ans;
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
