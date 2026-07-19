class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(0, 1, s, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(int left, int right, String s, List<List<String>> ans, List<String> cur) {
        if (right == s.length()) {
            if (isPalindrome(s, left, right)) {
                cur.add(s.substring(left, right));
                ans.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;

        }

        if (isPalindrome(s, left, right)) {
            cur.add(s.substring(left, right));
            backtrack(right, right+1, s, ans, cur);
            cur.remove(cur.size() - 1);
        }

        backtrack(left, right+1, s, ans, cur);

    }


    private boolean isPalindrome(String s, int left, int right) {
        while (left + 1 < right) {
            if (s.charAt(left) != s.charAt(right-1)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


