class Solution {
    public int climbStairs(int n) {
        int[] ways = new int[n];
        ways[0] = 1;

        if (n >= 2) {
            ways[1] = 2;
        }
        
        for (int i = 2; i < n; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }

        return ways[n-1];
    }
}
