class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }

    private void backtracking(int[] nums, int k, List<Integer> subset, Set<List<Integer>> ans) {
        if (k == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[k]);
        backtracking(nums, k+1, subset, ans);
        subset.remove(subset.size() - 1);
        backtracking(nums, k+1, subset, ans);
    }
}
