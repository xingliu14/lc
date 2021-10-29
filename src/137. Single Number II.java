// https://leetcode.com/problems/single-number-ii/
// 直接用hashMap简单的做，还有一种位运算简直就是杂种

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<> ();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : map.keySet()) {
            if(map.get(num) == 1) {
                return num;
            }
        }
        return 0;
    }
}