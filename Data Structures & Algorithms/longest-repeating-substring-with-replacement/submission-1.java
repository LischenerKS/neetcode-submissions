class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqByChar = new HashMap<>();
        
        int ans = 0;
        int left = 0;
        int cost;
        freqByChar.put(s.charAt(0), 1);
        
        for (int right = 1; right < s.length(); right++) {
            freqByChar.merge(s.charAt(right), 1, Integer::sum);
            cost = calcNeedK(freqByChar);
            while (cost > k) {
                freqByChar.merge(s.charAt(left), 1, (o, n) -> o-1);
                left++;
                cost = calcNeedK(freqByChar);
            }
            ans = Math.max(ans, right-left+1);

        }

        return ans;
    }

    private int calcNeedK(Map<Character, Integer> freqByChar) {
        int totalSum = 0;
        int totalMax = 0;
        int freq;
        for (Character c : freqByChar.keySet()) {
            freq = freqByChar.get(c);
            totalSum += freq;
            totalMax = Math.max(totalMax, freq);
        }
        return totalSum - totalMax;
    }
}
