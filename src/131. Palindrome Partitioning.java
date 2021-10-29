// https://leetcode.com/problems/palindrome-partitioning/
// backtrack来找所有的情况

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<> ();
        helper(result, new ArrayList<> (), 0, s);
        return result;
    }
    
    private void helper(List<List<String>> result, List<String> temp, int index, String s) {
        int total_len = 0;
        for(String str : temp) {
            total_len += str.length();
        }
        if(total_len == s.length()) {
            result.add(new ArrayList<> (temp));
            return;
        }
        for(int i = index + 1; i <= s.length(); i++) {
            if(isPalindrome(s.substring(index, i))) {
                temp.add(s.substring(index, i));
                helper(result, temp, i, s);
                temp.remove(temp.size() - 1);
            }
        }
        return;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}