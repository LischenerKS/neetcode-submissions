class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 1;  
        

        if (s.length() == 0) return 0;

        Map<Character, Integer> charsIndexes = new HashMap<>(); 
        charsIndexes.put(s.charAt(0), 0);
        int ans = 1;
        Character rightChar;
        while (right < s.length()) {
            rightChar = s.charAt(right);

            if (charsIndexes.containsKey(rightChar) && charsIndexes.get(rightChar) >= left) {
                left = charsIndexes.get(rightChar) + 1;
            }

            charsIndexes.put(rightChar, right);
            ans = Math.max(ans, right-left+1);
            right++;
        }
        
        return ans;
    }
}
