// https://leetcode.com/problems/valid-parentheses/
// stack的经典案例

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<> ();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else if(c == ')' && stack.pop() != '(') {
                    return false;
                } else if(c == '}' && stack.pop() != '{') {
                    return false;
                } else if(c == ']' && stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}