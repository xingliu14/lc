// https://leetcode.com/problems/generate-parentheses/
// 典型backtrack

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<> ();
        helper(n, 0, 0, new StringBuffer(), result);
        return result;
    }
    
    private void helper(int num, int left, int right, StringBuffer sb, List<String> result) {
        if(left == num && right == num) {
            result.add(sb.toString());
        }
        if(left < num) {
            sb.append('(');
            helper(num, left + 1, right, sb, result);
            sb.setLength(sb.length() - 1);
        }
        if(right < left) {
            sb.append(')');
            helper(num, left, right + 1, sb, result);
            sb.setLength(sb.length() - 1);
        }
        return;
    }
}