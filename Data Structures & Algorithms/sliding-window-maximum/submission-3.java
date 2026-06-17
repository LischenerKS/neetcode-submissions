class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // TreeMap с содержимым окна. Достаем самый большой ключ для каждого окна
        
        TreeMap<Integer, Integer> window = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            window.merge(nums[i], 1, Integer::sum);
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = window.lastKey();

        int left = 0;
        for (int right = k; right < nums.length; right++) {
            window.merge(nums[left], 1, (o, n) -> o-1);
            if (window.get(nums[left]) == 0) {
                window.remove(nums[left]);
            } 
            window.merge(nums[right], 1, Integer::sum);
            ans[left+1] = window.lastKey();
            left++;
        }


        return ans;
    }
}
