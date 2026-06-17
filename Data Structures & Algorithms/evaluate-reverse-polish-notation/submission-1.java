class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<String, java.util.function.BinaryOperator<Integer>> operators = new HashMap<>();
        operators.put("+", (a, b) -> a + b);
        operators.put("-", (a, b) -> a - b);
        operators.put("*", (a, b) -> a * b);
        operators.put("/", (a, b) -> a / b);

        int a,b;
        for (String token : tokens) {
            if (operators.containsKey(token)) {
                b = stack.pollLast();
                a = stack.pollLast();
                stack.addLast(operators.get(token).apply(a, b));
            }
            else {
                stack.addLast(Integer.parseInt(token));
            }
        }
        return stack.peekLast();
    }
}
