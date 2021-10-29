// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
// 因为他一次性切完，而且剩下的都是长方形，所以简单

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long maxH = 0, maxW = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for(int i = 0; i <= horizontalCuts.length; i++) {
            if(i == 0) {
                maxH = horizontalCuts[0];
            } else if(i == horizontalCuts.length) {
                maxH = Math.max(maxH, h - horizontalCuts[i - 1]);
            } else {
                maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
            }
        }
        for(int i = 0; i <= verticalCuts.length; i++) {
            if(i == 0) {
                maxW = verticalCuts[0];
            } else if(i == verticalCuts.length) {
                maxW = Math.max(maxW, w - verticalCuts[i - 1]);
            } else {
                maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
            }
        }
        return (int) ((maxH * maxW) % 1000000007);
    }
}