class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(nums, 0, new HashSet<>(), ans);
        return ans;
    }

    private void backtracking(int[] nums, int k, Set<Integer> subset, List<List<Integer>> ans) {
        if (k == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[k]);
        backtracking(nums, k+1, subset, ans);
        subset.remove(nums[k]);
        backtracking(nums, k+1, subset, ans);
    }
}
