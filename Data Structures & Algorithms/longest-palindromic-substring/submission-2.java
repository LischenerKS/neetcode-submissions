class Solution {
    public String longestPalindrome(String s) {
        String ans = s.substring(0, 1);
        
        int maxLength = 1;
        
        for (int i = 1; i < s.length() - 1; i++) {
            int curLength = 1;

            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && right <= (s.length() - 1) && s.charAt(left) == s.charAt(right)) {
                curLength += 2;
                if (maxLength < curLength) {
                    maxLength = curLength;
                    ans = s.substring(left, right + 1);
                }
                
                left--;
                right++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i+1)) continue;
            
            int curLength = 2;

            if (maxLength < curLength) {
                maxLength = curLength;
                ans = s.substring(i, i+2);
            }

            int left = i - 1;
            int right = i + 2;

            while (left >= 0 && right <= (s.length() - 1) && s.charAt(left) == s.charAt(right)) {
                curLength += 2;
                if (maxLength < curLength) {
                    maxLength = curLength;
                    ans = s.substring(left, right + 1);
                }
                
                left--;
                right++;
            }

        }

        return ans;
    }
}
