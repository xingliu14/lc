// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
// 直接按照它说的做就可以了

class Solution {
    public String removeDuplicates(String s, int k) {
        int prev = 0, curr = 0;
        StringBuilder sb = new StringBuilder (s);
        while(curr < sb.length() - 1) {
            curr++;
            if(sb.charAt(prev) != sb.charAt(curr)) {
                prev = curr;
            }
            if(curr - prev == k - 1) {
                sb.delete(prev, curr + 1);
                prev = Math.max(0, prev - 1);
                while(prev > 0 && sb.charAt(prev) == sb.charAt(prev - 1)) {
                    prev--;
                }
                curr = prev;
            }
        }
        return sb.toString();
    }
}