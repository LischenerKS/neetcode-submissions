class Solution {
    public boolean validPalindrome(String s) {
        return twoPointers(s, 0, s.length() - 1, true);
    }

    private boolean twoPointers(String s, int left, int right, boolean canSkipSymbol) {
        while (left < right) {
            if (!canSkipSymbol && s.charAt(left) != s.charAt(right)) {
                return false;
            }
            else if (canSkipSymbol && s.charAt(left) != s.charAt(right)) {
                return twoPointers(s, left+1, right, false) || twoPointers(s, left, right-1, false);
            }

            left++;
            right--;
        }
        return true;
    }
}