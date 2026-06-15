class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] frequentByNum = new int[2001];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            frequentByNum[num + 1000] += 1;
        }

        List<Set<Integer>> numsByFrequent = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            numsByFrequent.add(new HashSet<>());
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int frequent = frequentByNum[num + 1000];

            numsByFrequent.get(frequent).add(num);
        }

        int counter = 0;
        int[] ans = new int[k];

        for (int i = nums.length; i >= 0; i--) {
            for (int num : numsByFrequent.get(i)) {
                ans[counter] = num;
                counter++;
                if (counter == k) {
                    return ans;
                }
            }
        }
        return ans;
    }
}
