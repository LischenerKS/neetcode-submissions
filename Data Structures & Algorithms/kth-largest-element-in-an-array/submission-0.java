class Solution {
    private Queue<Integer> heap;
    private int k;

    public int findKthLargest(int[] nums, int k) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        for (int i : nums) {
            add(i);
        }
        return heap.peek();
    }

    private void add(int num) {
        heap.add(num);
        if (heap.size() > k) heap.poll();
    }
}
