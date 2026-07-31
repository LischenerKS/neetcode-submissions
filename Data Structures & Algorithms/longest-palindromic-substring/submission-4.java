class Solution {
    public String longestPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        int maxLength = 1;
        String ans = s.substring(0, 1);

        for (int left = s.length() - 1; left >= 0; left--) {
            for (int right = left; right < s.length(); right++) {
                if (right - left <= 2) { //l or lr or l_r
                    isPalindrome[left][right] = s.charAt(left) == s.charAt(right);
                }
                else {
                    isPalindrome[left][right] = s.charAt(left) == s.charAt(right) && isPalindrome[left+1][right-1];
                }


                if (isPalindrome[left][right] && right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    ans = s.substring(left, right+1);
                }
                
            }
        }
        return ans;
    }
}
