// https://leetcode.com/problems/summary-ranges/
// 处理边界

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<> ();
        int head = 0, tail = 1;
        while(tail <= nums.length) {
            if(tail == nums.length || nums[tail] != nums[tail - 1] + 1) {
                int temp = tail - 1;
                if(head == temp) {
                    result.add("" + nums[head]);
                } else {
                    result.add(nums[head] + "->" + nums[temp]);
                }
                head = tail;
            }
            tail++;
        }
        return result;
    }
}