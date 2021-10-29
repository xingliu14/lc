// https://leetcode.com/problems/3sum/
// 对于3sum的情况，还不算太复杂。可以先sort再固定住第一个，双指针找另外两个，需要跳过所有之前出现过的。更多的sum就需要用backtrack了

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while(left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while(right > i && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else if(nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                    while(right > i && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else {
                    left++;
                    while(left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
            while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}