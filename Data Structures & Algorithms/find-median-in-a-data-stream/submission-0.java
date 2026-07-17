class MedianFinder {
    private Queue<Integer> less;
    private Queue<Integer> more;
    private Double median;
    
    // меньше (maxHeap) - медиана - больше (minHeap)

    public MedianFinder() {
        this.less = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        this.more = new PriorityQueue<>();
        this.median = 100_001.0; 
    }
    
    public void addNum(int num) {
        if (num > median) {
            more.add(num);
        }
        else {
            less.add(num);
        }

        if (less.size() > more.size() + 1) {
            more.add(less.poll());
        }
        else if (more.size() > less.size() + 1) {
            less.add(more.poll());
        }


        if (less.size() == more.size()) {
            this.median = (less.peek() + more.peek()) * 1.0 / 2;
        }
        else if (less.size() >= more.size()) {
            this.median = (double) less.peek();
        }
        else {
           this.median = (double) more.peek(); 
        }
    }
    
    public double findMedian() {
        return this.median;
    }
}
