class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i : stones) {
            queue.add(i);
        }

        int x,y;
        while (queue.size() > 1) {
            x = queue.poll();
            y = queue.poll();

            if (x > y) {
                queue.add(x-y);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
