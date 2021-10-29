// https://leetcode.com/problems/basic-calculator/
// 只需要搞清楚每个数应该加还是减即可，逻辑还是有些复杂的，特别注意最开始的初始化和最后一个数的处理。

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int result = 0, sign = 1, curr = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<> ();
        for(char c : s.trim().toCharArray()) {
            if(Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            } else if(c == '+') {
                result += curr * sign;
                curr = 0;
                sign = 1;
            } else if(c == '-') {
                result += curr * sign;
                curr = 0;
                sign = -1;
            } else if(c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if(c == ')') {
                result += curr * sign;
                result *= stack.pop();
                result += stack.pop();
                curr = 0;
            }
        }
        return result + curr * sign;
    }
}