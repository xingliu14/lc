// https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
// 想象成阶梯

class Solution {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<> ();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0, diff = 0;
        for(Integer count : map.values()) {
            result += diff * count;
            diff++;
        }
        return result;
    }
}