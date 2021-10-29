// https://leetcode.com/problems/fair-candy-swap/
// 直接做

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int a_sum = 0, b_sum = 0;
        Set<Integer> a_set = new HashSet<> (), b_set = new HashSet<> ();
        for(int candy : aliceSizes) {
            a_sum += candy;
            a_set.add(candy);
        }
        for(int candy : bobSizes) {
            b_sum += candy;
            b_set.add(candy);
        }
        int diff = (a_sum - b_sum) / 2;
        for(int candy : a_set) {
            if(b_set.contains(candy - diff)) {
                return new int[] {candy, candy - diff};
            }
        }
        return new int[] {0, 0};
    }
}