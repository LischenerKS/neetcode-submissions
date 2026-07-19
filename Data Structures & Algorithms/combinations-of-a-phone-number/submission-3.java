class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> digitToLettersList = new HashMap<>();
        digitToLettersList.put('2', new ArrayList<>(List.of("a", "b", "c")));
        digitToLettersList.put('3', new ArrayList<>(List.of("d", "e", "f")));
        digitToLettersList.put('4', new ArrayList<>(List.of("g", "h", "i")));
        digitToLettersList.put('5', new ArrayList<>(List.of("j", "k", "l")));
        digitToLettersList.put('6', new ArrayList<>(List.of("m", "n", "o")));
        digitToLettersList.put('7', new ArrayList<>(List.of("p", "q", "r", "s")));
        digitToLettersList.put('8', new ArrayList<>(List.of("t", "u", "v")));
        digitToLettersList.put('9', new ArrayList<>(List.of("w", "x", "y", "z")));


        List<String> ans = new ArrayList<>();

        backtrack(digitToLettersList, new StringBuilder(), ans, digits);

        return ans;
    }

    private void backtrack(
        Map<Character, List<String>> digitToLettersList, StringBuilder sb, List<String> ans, String digits
    ) {
        if (sb.length() == digits.length()) {
            if (digits.length() > 0) {
                ans.add(sb.toString());
            }
        
            return;
        }

        for (String c : digitToLettersList.get(digits.charAt( sb.length() ))) {
            sb.append(c);

            backtrack(digitToLettersList, sb, ans, digits);

            sb.deleteCharAt(sb.length() - 1);            
        }        

    }
}
