class Solution {
    public boolean isValid(String s) {
        Deque<Character> deq = new ArrayDeque<>();
        
        deq.addLast('K');

        for (Character c : s.toCharArray()) {

            if (c == ')') {
                if (deq.peekLast() == '(') deq.removeLast();
                else return false;
            }
            else if (c == ']') {
                if (deq.peekLast() == '[') deq.removeLast();
                else return false;
            }
            else if (c == '}') {
                if (deq.peekLast() == '{') deq.removeLast();
                else return false;
            }
            else deq.addLast(c);
        }
        return deq.size() == 1;
    }
}
