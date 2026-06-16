class Solution {
    public int maxProfit(int[] prices) {
        int[] minPricePerDay = new int[prices.length];
        minPricePerDay[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPricePerDay[i] = Math.min(prices[i], minPricePerDay[i-1]);
        }

        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans,prices[i] - minPricePerDay[i-1]);
        }
        return ans;
    }
}
