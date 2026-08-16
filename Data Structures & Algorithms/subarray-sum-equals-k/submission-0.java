class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Set<Integer>> subarraysBySum = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (!subarraysBySum.containsKey(sum)) {
                subarraysBySum.put(sum, new HashSet<>());
            }

            subarraysBySum.get(sum).add(i);
        }

        sum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int needed = sum - k;

            if (needed == 0) {
                cnt++;
            }

            if (!subarraysBySum.containsKey(needed)) {
                continue;
            }

            for (Integer right : subarraysBySum.get(needed)) {
                if (right < i) {
                    cnt++;
                }
            }
        }

        return cnt;
        // [n, k] = [0, k] - [o,n]
        // n между 0 и k
        // в моменте нам надо за константу проверить был ли у нас такой подотрезок с нашей суммой

        // Map<Integer, Set<Integer>> subarraysBySum // [0, k]

        

        // 0 до K есть отрезок с суммой T
        // по сумме достать
    }
}