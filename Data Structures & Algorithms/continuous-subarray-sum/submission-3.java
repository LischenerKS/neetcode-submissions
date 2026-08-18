class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Set<Integer>> setOfTailsByRemainder = new HashMap<>();
        
        int remainder = 0;
        for (int i = 0; i < nums.length; i++) {
            remainder += nums[i];
            remainder = remainder % k;

            if (!setOfTailsByRemainder.containsKey(remainder)) {
                setOfTailsByRemainder.put(remainder, new HashSet<>());
            }

            setOfTailsByRemainder.get(remainder).add(i);
        }


        remainder = 0;
        for (int i = 0; i < nums.length; i++) {
            remainder += nums[i];
            remainder = remainder % k;

            if (remainder == 0 && i >= 1) {
                return true;
            }

            Set<Integer> tails = setOfTailsByRemainder.get(remainder);

            for (Integer tail : tails) {
                if (i - tail > 1) {
                    return true;
                }
            }
        }

        return false;        
    }
}