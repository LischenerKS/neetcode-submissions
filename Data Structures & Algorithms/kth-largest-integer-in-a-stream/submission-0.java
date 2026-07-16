class KthLargest {
    private Queue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.k = k;

        for (int i : nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        queue.add(val);

        if (queue.size() > k) {
            queue.poll();
        }

        return queue.peek();
    }
}
