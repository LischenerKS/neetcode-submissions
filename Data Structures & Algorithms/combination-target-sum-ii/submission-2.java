class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, ans, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] candidates, int target, int curSum, int k, List<List<Integer>> ans, List<Integer> curComb) {
        if (curSum == target) {
            ans.add(new ArrayList<>(curComb));
            return;
        }
        else if (curSum > target) {
            return;
        }
        else if (k >= candidates.length) {
            return;
        }
        


        curComb.add(candidates[k]);
        dfs(candidates, target, curSum + candidates[k], k+1, ans, curComb);
        curComb.remove(curComb.size() - 1);
        
        int newK = k;
        while (newK < candidates.length && candidates[k] == candidates[newK]) {
            newK++;
        }
        if (newK < candidates.length && candidates[k] != candidates[newK]) {
            dfs(candidates, target, curSum, newK, ans, curComb);
        }
        
    }
}
