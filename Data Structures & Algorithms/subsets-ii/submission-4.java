class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(nums, new ArrayList<>(), ans, 0);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> cur, List<List<Integer>> ans, int k) {
        if (k == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        

        cur.add(nums[k]);
        backtrack(nums, cur, ans, k+1);
        cur.remove(cur.size() - 1);


        int newK = k;

        while (newK < nums.length && nums[newK] == nums[k]) {
            newK++;
        }


        backtrack(nums, cur, ans, newK);
        
        
    }
}
