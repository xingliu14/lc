// https://leetcode.com/problems/one-edit-distance/
// 不需要用Edit Distance来做，因为时间复杂度太高。直接每种情况单股考虑

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() == t.length()) {
            boolean replaced = false;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    if(replaced) {
                        return false;
                    }
                    replaced = true;
                }
            }
            return replaced;
        }
        
        if(Math.abs(s.length() - t.length()) == 1) {
            if(t.length() < s.length()) {
                String temp = t;
                t = s;
                s = temp;
            }
            boolean inserted = false;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != t.charAt(i + (inserted ? 1 : 0))) {
                    if(inserted) {
                        return false;
                    }
                    inserted = true;
                    i--;
                }
            }
            return true;
        }
        
        return false;
    }
}