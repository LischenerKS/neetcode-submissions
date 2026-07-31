class Solution {
    public int countSubstrings(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        int cnt = 0;
        for (int left = s.length() - 1; left >= 0; left--) {
            for (int right = left; right < s.length(); right++) {
                if (right - left <= 2) {
                    isPalindrome[left][right] = s.charAt(left) == s.charAt(right);
                }
                else {
                    isPalindrome[left][right] = s.charAt(left) == s.charAt(right) && isPalindrome[left+1][right-1];
                }

                if (isPalindrome[left][right]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
