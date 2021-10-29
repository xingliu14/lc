// https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
// 直接计数

class Solution {
    public boolean checkZeroOnes(String s) {
        int[] max = new int[2];
        int currMax = 0;
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            if(i == 0) {
                max[c] = 1;
                currMax = 1;
            } else {
                if(c == s.charAt(i - 1) - '0') {
                    currMax++;
                    max[c] = Math.max(max[c], currMax);
                } else {
                    currMax = 1;
                    max[c] = Math.max(max[c], currMax);
                }
            }
        }
        return max[1] > max[0];
    }
}