class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        Stack<Integer> wait = new Stack<>();
        int waitIndex;

        for (int i = 0; i < temperatures.length; i++) {
            while (!wait.isEmpty() && temperatures[i] > temperatures[wait.peek()]) {
                waitIndex = wait.pop();
                ans[waitIndex] = i - waitIndex;
            }

            wait.push(i);
        }
        return ans;

        
    }
}
