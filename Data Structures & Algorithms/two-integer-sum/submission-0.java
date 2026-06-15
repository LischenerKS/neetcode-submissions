class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> coupleIndexByNumber = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer coupleIndex = coupleIndexByNumber.get(num);

            if (coupleIndex != null) {
                int[] ans = new int[2];
                ans[0] = Math.min(i, coupleIndex);
                ans[1] = Math.max(i, coupleIndex);
                return ans;
            }
            else {
                coupleIndexByNumber.put(target-num, i);
            }
            
        }
        return new int[0];
    }
}
