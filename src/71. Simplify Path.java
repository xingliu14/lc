// https://leetcode.com/problems/simplify-path/
// split("/")能省很多事

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<String>();

        for(String token : path.split("/")) {
            if(token.equals("..")) {
               if(!stack.isEmpty()) {
                   stack.pop();
               }
            } else if(!token.isEmpty() && !token.equals(".")) {
                stack.push(token);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append("/").append(stack.pollLast());   
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}