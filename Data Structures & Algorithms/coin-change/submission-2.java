class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];
        // 0 1 2 3 4 5 6
        // 0 1 1 0 0 0 0 

        for (int i = 1; i <= amount; i++) {
            boolean isNeededCoinsExists = false;
            for (int coin : coins) {
                if (i >= coin && amounts[i-coin] != -1) {
                    if (amounts[i] == 0) {
                        amounts[i] = amounts[i-coin] + 1;
                    }
                    else {
                        amounts[i] = Math.min(amounts[i], amounts[i-coin] + 1);
                    }
                    isNeededCoinsExists = true;
                }
            }

            if (!isNeededCoinsExists) {
                amounts[i] = -1;
            }   
        }
        return amounts[amount];
        
    }
}
