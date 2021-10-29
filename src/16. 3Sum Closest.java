// https://leetcode.com/problems/3sum-closest/
// 和3sum类似的遍历方式，不过每次要比较绝对值大小

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for(int i = 0; i < nums.length - 2; i++) {
            int head = i + 1, tail = nums.length - 1;
            while(head < tail) {
                if(nums[i] + nums[head] + nums[tail] == target) {
                    return target;
                } else if(nums[i] + nums[head] + nums[tail] > target) {
                    result = nums[i] + nums[head] + nums[tail] - target < Math.abs(result - target) ? nums[i] + nums[head] + nums[tail] : result;
                    tail--;
                } else {
                    result = target - nums[i] - nums[head] - nums[tail] < Math.abs(result - target) ? nums[i] + nums[head] + nums[tail] : result;
                    head++;
                }
            }
        }
        return result;
    }
}