class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> existingByNum = new TreeMap<>();

        for (int i : nums) {
            existingByNum.put(i, 1);
        }

        int old = Integer.MIN_VALUE;
        int curSeqLength = 0;
        int maxSeqLength = 0;
        for (int cur : existingByNum.keySet()) {
            if (cur - old == 1) {
                curSeqLength += 1;
                maxSeqLength = curSeqLength > maxSeqLength ? curSeqLength : maxSeqLength;
            }
            else {
                curSeqLength = 1;
                maxSeqLength = curSeqLength > maxSeqLength ? curSeqLength : maxSeqLength;
            }
            old = cur;
        }
        return maxSeqLength;
    }
}
