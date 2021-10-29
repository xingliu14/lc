// https://leetcode.com/problems/two-sum/
// 用一个HashMao存之前所有数的剩下的数，一旦对应到就return。因为用了HashMap，所以时间空间复杂度均为O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<> ();
        for(int i = 0; i < nums.length; i++) {
            if(map.keySet().contains(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}