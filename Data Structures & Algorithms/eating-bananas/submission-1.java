class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        
        int k;
        int curH;
        int minSuitableK = Integer.MAX_VALUE;
        while (right - 1 > left) {
            k = (right - left) / 2 + left;
            curH = culcHforK(piles, k);
            
            if (curH <= h) {
                minSuitableK = Math.min(k, minSuitableK);
                right = k;
            }
            else {
                left = k;
            }
        }
        return minSuitableK;
    }

    public int culcHforK(int[] piles, int k) {
        int ans = 0;
        for (int pile : piles) {
            ans += (int) Math.ceil(pile * 1.0 / k); 
        }
        return ans;
    }
}
