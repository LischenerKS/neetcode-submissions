class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // число -> частота
        // nums.length * (1+log)
        // Х макс частот -> числа

        List<Integer> frequentByNum = new ArrayList<>(2001);
        List<List<Integer>> groupByFrequent = new ArrayList<>(2002); 

        for (int i = 0; i < 2001; i++) {
            frequentByNum.add(0);
            groupByFrequent.add(new ArrayList<>());
        }
        groupByFrequent.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer oldFrequent = frequentByNum.get(num + 1000);
            frequentByNum.set(num + 1000, oldFrequent + 1);

            groupByFrequent.get(oldFrequent).remove(Integer.valueOf(num));
            groupByFrequent.get(oldFrequent + 1).add(num);
        }
        
        int counter = 0;
        int[] ans = new int[k];

        for (int i = 2001; i >= 0; i--) {
            List<Integer> group = groupByFrequent.get(i);
            if (group.size() != 0) {
                for (Integer ansNum : group) {
                    ans[counter] = ansNum;
                    counter++;

                    if (counter == k) {
                        return ans;
                    }
                }
            }
        }
        return new int[2];
    }

}
