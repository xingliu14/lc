// https://leetcode.com/problems/evaluate-reverse-polish-notation/
// 标准的stack题，注意String比较的时候需要写str.equals()

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<> ();
        for(String str : tokens) {
            if(!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                stack.push(Integer.valueOf(str));
            } else {
                int num1 = stack.pop(), num2 = stack.pop();
                if(str.equals("+")) {
                    stack.push(num2 + num1);
                }
                if(str.equals("-")) {
                    stack.push(num2 - num1);
                }
                if(str.equals("*")) {
                    stack.push(num2 * num1);
                }
                if(str.equals("/")) {
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.pop();
    }
}