// https://leetcode.com/problems/maximum-number-of-removable-characters/
// 我对binary search的理解又加强了

class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] a = s.toCharArray();
        char[] b = p.toCharArray();
        boolean[] removed = new boolean[a.length];
        
        int l = 0;
        int r = removable.length;
        while(l < r){
            int m = (l + r + 1) / 2;
            Arrays.fill(removed, false);
            for(int j = 0; j < m; j++){
                removed[removable[j]] = true;
            }
            if(substring(removed, a, b)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
    
    public boolean substring(boolean[] removed, char[] a, char[] b){
        int j = 0;
        for(int i = 0; i < a.length && j < b.length; i++){
            if(removed[i]) {
                continue;
            }
            if(a[i] == b[j]) {
                j++;
            }
        }
        return j == b.length;
    }
}