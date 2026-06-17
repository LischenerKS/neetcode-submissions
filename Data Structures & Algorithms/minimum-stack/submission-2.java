class MinStack {
    //для каждого хранить минимум снизу

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minElementUnderMe = new ArrayDeque<>();

    public MinStack() {
        minElementUnderMe.addLast(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        stack.addLast(val);
        minElementUnderMe.addLast(Math.min(minElementUnderMe.peekLast(), val));
    }
    
    public void pop() {
        stack.removeLast();
        minElementUnderMe.removeLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minElementUnderMe.peekLast();
    }
}
