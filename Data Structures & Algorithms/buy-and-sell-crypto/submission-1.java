class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = 1000;
        int maxDelta = 0;

        for (int price : prices) {
            maxDelta = Math.max(maxDelta, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxDelta;
    }
}
