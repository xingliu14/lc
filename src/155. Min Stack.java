// https://leetcode.com/problems/min-stack/
// 这道题有一个stack很重要的性质：之前的就不会再改变了，通过这一点就能用stack实现了

class MinStack {
    
    private Deque<Integer> stack;
    private Deque<int[]> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<> ();
        minStack = new ArrayDeque<> ();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new int[]{x, 1});
        } else if(x == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
        return;
    }
    
    public void pop() {
        int x = stack.pop();
        if(x == minStack.peek()[0]) {
            if(minStack.peek()[1] == 1) {
                minStack.pop();
            } else {
                minStack.peek()[1]--;
            }
        }
        return;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
    }
}