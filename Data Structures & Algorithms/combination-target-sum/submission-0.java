class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(new ArrayList<>(), nums, target, 0, ans, 0);
        return ans;
    }

    private void dfs(List<Integer> curComb, int[] nums, int target, int curSum, List<List<Integer>> ans, int start) {
        if (curSum == target) {
            ans.add(new ArrayList<>(curComb));
            return;
        }
        else if (curSum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            curComb.add(nums[i]);
            dfs(curComb, nums, target, curSum+nums[i], ans, i);
            curComb.remove(curComb.size() - 1);
        }
    }

}
