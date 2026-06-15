class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> lettersS = new HashMap<>();
        Map<Character, Integer> lettersT = new HashMap<>();

        for (Character c : s.toCharArray()) {
            Integer counter = lettersS.get(c);
            if (counter == null) {
                lettersS.put(c, 1);
            }
            else {
                lettersS.put(c, counter + 1);
            }
        }

        for (Character c : t.toCharArray()) {
            Integer counter = lettersT.get(c);
            if (counter == null) {
                lettersT.put(c, 1);
            }
            else {
                lettersT.put(c, counter + 1);
            }
        }

        return lettersS.equals(lettersT);
    }
}
