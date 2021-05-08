
class MinStack {

    Deque<Integer> stack;
    Deque<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList();
        min = new LinkedList();
    }
    
    public void push(int val) {
        if (stack.size() == 0) {
            stack.add(val);
            min.add(val);
        } else {
            stack.add(val);
            min.add(Math.min(val, min.peekLast()));
        }
    }
    
    public void pop() {
        min.removeLast();
        stack.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return min.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
