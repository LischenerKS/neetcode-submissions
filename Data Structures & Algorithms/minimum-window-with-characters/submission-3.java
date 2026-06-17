class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> neededFreqMap = new HashMap<>();
        Map<Character, Integer> curFreqMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            neededFreqMap.merge(t.charAt(i), 1, Integer::sum);
        }

        int left = 0;
        String ans = "";
        String curAns;

        int totalMinLength = Integer.MAX_VALUE;
        int curLength = Integer.MAX_VALUE;


        curFreqMap.put(s.charAt(0), 1);

        if (isCurContainsNeeded(curFreqMap, neededFreqMap)) { //length = 1 and its okey
            return t;
        }

        boolean isDecremented = false;

        for (int right = 1; right < s.length(); right++) {
            if (left != right && !isDecremented) {
                curFreqMap.merge(s.charAt(right), 1, Integer::sum);
            }

            if (isDecremented) { 
                isDecremented = false;
            }

            if (left > right) {
                break;
            }

            if (isCurContainsNeeded(curFreqMap, neededFreqMap)) {


                while (isCurContainsNeeded(curFreqMap, neededFreqMap)) {
                    curAns = s.substring(left, right + 1);
                    curLength = curAns.length();

                    if (curLength < totalMinLength) {
                        totalMinLength = curLength;
                        ans = curAns;
                    }
                    curFreqMap.merge(s.charAt(left), 1, (o, n) -> o-1);
                    left++;
                }


                right--;
                isDecremented = true;

            }

        }

        return ans;
    }

    private boolean isCurContainsNeeded(
        Map<Character, Integer> cur,
        Map<Character, Integer> needed
    ) {
        for (Character c : needed.keySet()) {
            if (!cur.containsKey(c)) {
                return false;
            }
            if (cur.get(c) < needed.get(c)) {
                return false;
            }
        }
        return true;
    }
}
