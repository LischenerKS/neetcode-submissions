class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length != set.size(); 
        
    }
}