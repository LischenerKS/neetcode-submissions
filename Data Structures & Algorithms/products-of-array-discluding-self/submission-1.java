class Solution {
    public int[] productExceptSelf(int[] nums) {
        //найти общее произведение 
        //output[i] = totalProduct // nums[i]

        long totalProductWithoutZeroes = 1;
        long totalProductWithZeroes = 1;
        int zeroCounter = 0;
        for (int i : nums) { 
            if (i != 0) {
                totalProductWithoutZeroes *= i;
            }
            if (i == 0) {
                zeroCounter++;
            }
            totalProductWithZeroes *= i;
        }

        int[] output = new int[nums.length];
        if (zeroCounter >= 2) {
            return output;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && totalProductWithZeroes != 0) {
                output[i] = (int) totalProductWithoutZeroes / nums[i];
            }
            else {
                output[i] = (nums[i] == 0) ? (int) totalProductWithoutZeroes : 0;
            }
            
        }
        return output;
    }
}  
