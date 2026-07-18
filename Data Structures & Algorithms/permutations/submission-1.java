class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        generatePermutations(nums, new ArrayList<>(), ans, nums.length, new boolean[nums.length]);

        return ans;
    }

    private void generatePermutations(int[] nums, List<Integer> perm, List<List<Integer>> ans, int permLength, boolean[] isNumUsed) {
        if (permLength == perm.size()) {
            ans.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isNumUsed[i]) {
                perm.add(nums[i]);
                isNumUsed[i] = true;

                generatePermutations(nums, perm, ans, permLength, isNumUsed);

                perm.remove(perm.size() - 1);
                isNumUsed[i] = false;
            }
        }
    }
}
