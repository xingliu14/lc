// https://leetcode.com/problems/max-stack/
// 对于popMax()来说，我们直接对两个stack进行完整的pop()和push()操作

class MaxStack {
    ArrayDeque<Integer> stack;
    ArrayDeque<Integer> maxStack;

    public MaxStack() {
        stack = new ArrayDeque();
        maxStack = new ArrayDeque();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}