class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        int right = 1;

        while (right < prices.length) {
            int delta = prices[right] - prices[left];

            if (delta < 0) {
                left = right;
                right++;
            }
            else {
                profit = Math.max(profit, delta);
                right++;
            }
        }

        return profit;
    }
}
