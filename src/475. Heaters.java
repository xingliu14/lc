// https://leetcode.com/problems/heaters/
// 双指针，注意对于边界情况的处理

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int max_distance = -1, left = -1, right = heaters[0], right_index = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for(int i = 0; i < houses.length; i++) {
            while(right_index < heaters.length && heaters[right_index] <= houses[i]) {
                right_index++;
            }
            left = right_index == 0 ? -1 : heaters[right_index - 1];
            right = right_index < heaters.length ? heaters[right_index] : Integer.MAX_VALUE;
            int left_distance = left == -1 ? Integer.MAX_VALUE : houses[i] - left;
            int right_distance = right == Integer.MAX_VALUE ? Integer.MAX_VALUE : right - houses[i];
            max_distance = Math.max(max_distance, Math.min(left_distance, right_distance));
        }
        return max_distance;
    }
}