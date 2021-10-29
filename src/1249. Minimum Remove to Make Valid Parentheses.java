// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// 用stack即可，需要注意最后的stack的剩下的一定是最后的，所以还需要剪掉list的size

class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<> ();
        List<Integer> toRemove = new ArrayList<> ();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else if(c == ')') {
                if(stack.isEmpty()) {
                    toRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder (s);
        for(int i = toRemove.size() - 1; i >= 0; i--) {
            sb.deleteCharAt(toRemove.get(i));
        }
        while(!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop() - toRemove.size());
        }
        return sb.toString();
    }
}