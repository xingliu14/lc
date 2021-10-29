// https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
// 分别考虑

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean find0 = false, find1 = false, find2 = false;
        for(int[] tri : triplets) {
            if(tri[0] == target[0] && tri[1] <= target[1] && tri[2] <= target[2]) {
                find0 = true;
            }
            if(tri[0] <= target[0] && tri[1] == target[1] && tri[2] <= target[2]) {
                find1 = true;
            }
            if(tri[0] <= target[0] && tri[1] <= target[1] && tri[2] == target[2]) {
                find2 = true;
            }
        }
        
        return find0 && find1 && find2;
    }
}