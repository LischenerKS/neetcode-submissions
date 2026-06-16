class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);



        Set<List<Integer>> unicAns = new HashSet<>();

        int target;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            target = -nums[i];
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (left == i) left++;
                if (right == i) right--;
                if (left == right) break;
                sum = nums[left] + nums[right];
                if (sum < target) {
                    left++;
                } 
                else if (sum > target) {
                    right--;
                }
                else {
                    List<Integer> ansNode = new ArrayList<>(List.of(nums[left], nums[i], nums[right]));
                    Collections.sort(ansNode);
                    unicAns.add(ansNode);
                    left++;
                }
            }     
        }


        return new ArrayList<>(unicAns);
    }
}
