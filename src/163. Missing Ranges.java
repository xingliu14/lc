// https://leetcode.com/problems/missing-ranges/
// 遍历nums而不是整个range

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<> ();
        int head = lower, tail = lower;
        for(int num : nums) {
            tail = num - 1;
            if(head == tail) {
                result.add(String.valueOf(head));
            } else if(head < tail) {
                result.add(head + "->" + tail);
            }
            head = num + 1;
        }
        if(head == upper) {
            result.add(String.valueOf(head));
        } else if(head < upper) {
            result.add(head + "->" + upper);
        }
        return result;
    }
}