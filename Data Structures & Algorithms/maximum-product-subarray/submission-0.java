class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int min = 1;
        int max = 1;

        int zeroCnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i] * max;
                max = max(nums[i] * max, nums[i] * min, nums[i]);
                min = min(temp, nums[i] * min, nums[i]);

                ans = Math.max(ans, max);
            }
            else {
                min = 1;
                max = 1;
                zeroCnt++;
            }
        }

        return (zeroCnt > 0) ? Math.max(ans, 0) : ans;
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
