class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> neededFreqMap = new HashMap<>(); //for s1
        Map<Character, Integer> curFreqMap = new HashMap<>(); //for s2


        for (int i = 0; i < s1.length(); i++) {
            neededFreqMap.merge(s1.charAt(i), 1, Integer::sum);
        }


        int left = 0;//if length == 1?
        curFreqMap.put(s2.charAt(0), 1);

        int status = curMapEqualsNeededMapStatus(curFreqMap, neededFreqMap);
        if (status == 2) return true;
        for (int right = 1; right < s2.length(); right++) {
            curFreqMap.merge(s2.charAt(right), 1, Integer::sum);
            status = curMapEqualsNeededMapStatus(curFreqMap, neededFreqMap);


            //for status == 0: continue
            while (status == 1) {
                curFreqMap.merge(s2.charAt(left), 1, (o, n) -> o-1);
                left++;
                status = curMapEqualsNeededMapStatus(curFreqMap, neededFreqMap);
            }

            if (status == 2) {
                return true;
            }
        }

        return status == 2;

    }

    // 0 - не хватает символов
    // 1 - слишком много какого-то из символов
    // 2 - все ок
    private int curMapEqualsNeededMapStatus
    (
        Map<Character, Integer> cur,
        Map<Character, Integer> needed
    ) 
    {   
        for (Character c : needed.keySet()) {
            if (!cur.containsKey(c)) {
                return 0;
            }
            else if (needed.get(c) > cur.get(c)) {
                return 0;
            }
            else if (needed.get(c) < cur.get(c)) {
                return 1;
            }
        }

        for (Character c : cur.keySet()) {
            if (!needed.containsKey(c) && cur.get(c) != 0) {
                return 1;
            }
        }
        return 2;
    }
}
