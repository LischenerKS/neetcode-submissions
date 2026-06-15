class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> existingByNum = new HashMap<>();

        for (int i : nums) {
            existingByNum.put(i, 1);
        }

        int maxLength = 0;
        for (int i : nums) {
            if (!existingByNum.containsKey(i-1)) {
                int curLength = 0;
                while (existingByNum.containsKey(i+curLength)) {
                    curLength += 1;
                }
                maxLength = curLength > maxLength ? curLength : maxLength;
            }
        }
        return maxLength;
    }
}
