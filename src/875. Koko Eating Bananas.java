// https://leetcode.com/problems/koko-eating-bananas/
// 酷酷binary search

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;
        
        for(int pile : piles) {
            max = Math.max(max, pile);
        }
        
        if(h == piles.length) {
            return max;
        }
        
        while(min <= max) {
            int mid = min + (max - min) / 2, time = 0;
            for(int pile : piles) {
                time += pile / mid;
                if(pile % mid != 0) {
                    time++;
                }
                if(time > h) {
                    break;
                }
            }
            if(time > h) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        return min;
    }
}